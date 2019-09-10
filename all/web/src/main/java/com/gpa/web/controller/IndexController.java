package com.gpa.web.controller;

import com.gpa.engine.dto.StudentDTO;
import com.gpa.engine.jcollibri.Gpa;
import com.gpa.engine.jcollibri.GpaDescription;
import com.gpa.engine.model.Student;
//import com.gpa.engine.service.StudentService;
import com.gpa.web.constants.URLConstants;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import es.ucm.fdi.gaia.jcolibri.cbraplications.StandardCBRApplication;
import es.ucm.fdi.gaia.jcolibri.cbrcore.CBRQuery;
import es.ucm.fdi.gaia.jcolibri.datatypes.Instance;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.gpa.web.constants.FileConstraints.CASES_CSV_FILE_PATH;
import static com.gpa.web.constants.FileConstraints.OUT_CSV_FILE_PATH;

@Controller
public class IndexController {




    /*@Autowired
    private StudentService studentService;*/

    @RequestMapping(value = URLConstants.URLs.INDEX)
    public String index() {
        return URLConstants.Views.INDEX;
    }

    @RequestMapping(value = URLConstants.URLs.ADMIN)
    public String admin() {
        return URLConstants.Views.ADMIN;
    }

    @RequestMapping(value = URLConstants.URLs.STUDENT)
    public String student() {
        return URLConstants.Views.STUDENT;
    }

    @RequestMapping(value = URLConstants.URLs.PREDICTED)
    public String index(@RequestParam String gpa, Model model) {
        model.addAttribute("gpaValue", gpa);
        return URLConstants.Views.PREDICTED;
    }

    @RequestMapping(value = URLConstants.URLs.SAVE_CASE)
    public String list(@RequestParam String regNo, Model model) {
        model.addAttribute("regNo", regNo);
        return URLConstants.Views.SAVED_CASES;
    }

    @PostMapping(value = URLConstants.URLs.SAVE)
    public String studentCase(StudentDTO studentDTO){
        Student studentCase = new Student();
        studentCase.setRegistrationNumber(studentDTO.getRegistrationNumber());
        studentCase.setPriorKnowledge(studentDTO.getPriorKnowledge());
        studentCase.setHoursOfWeeklyStudyI(studentDTO.getHoursOfWeeklyStudyI());
        studentCase.setHoursOfWeeklyStudyII(studentDTO.getHoursOfWeeklyStudyII());
        studentCase.setInteractionWithLecturer(studentDTO.getInteractionWithLecturer());
        studentCase.setGPAYearI(studentDTO.getGpaYearI());
        studentCase.setGPAYearII(studentDTO.getGpaYearII());
        studentCase.setDevelopedProjects(studentDTO.getDevelopedProjects());
//        studentService.save(studentCase);
        String gpa = null;
        try {
            gpa = getSavedGpa(studentDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return URLConstants.Redirects.PREDICTED + "?gpa=" + gpa;

    }

    @PostMapping(value = URLConstants.URLs.SAVE_CASE)
    public String createCase(StudentDTO studentDTO) throws Exception{
        Student studentCase = new Student();
        studentCase.setRegistrationNumber(studentDTO.getRegistrationNumber());
        studentCase.setPriorKnowledge(studentDTO.getPriorKnowledge());
        studentCase.setHoursOfWeeklyStudyI(studentDTO.getHoursOfWeeklyStudyI());
        studentCase.setHoursOfWeeklyStudyII(studentDTO.getHoursOfWeeklyStudyII());
        studentCase.setInteractionWithLecturer(studentDTO.getInteractionWithLecturer());
        studentCase.setGPAYearI(studentDTO.getGpaYearI());
        studentCase.setGPAYearII(studentDTO.getGpaYearII());
        studentCase.setFinalGpa(studentDTO.getFinalGpa());
        studentCase.setDevelopedProjects(studentDTO.getDevelopedProjects());
        //studentService.save(studentCase);

        CSVWriter csvWriter = null;
        try {
            csvWriter = new CSVWriter(new FileWriter(CASES_CSV_FILE_PATH, true));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String regNo = studentCase.getRegistrationNumber();
        String priorKnowledge = "2";//studentCase.getPriorKnowledge().toString();
        String hoursI = "2";//studentCase.getHoursOfWeeklyStudyI().toString();
        String hoursII = "";//studentCase.getHoursOfWeeklyStudyII().toString();
        String gpaI = "2";//studentCase.getGPAYearI().toString();
        String gpaII = "";//studentCase.getGPAYearII().toString();
        String devProjects = "2";//studentCase.getDevelopedProjects().toString();
        String interactionLecturer = "2";//studentCase.getInteractionWithLecturer().toString();
        String finalGpa = "2";//studentCase.getFinalGpa().toString();
        String newLine = "\n";//studentCase.getFinalGpa().toString();
        String[] records = {regNo, priorKnowledge, hoursI, hoursII, interactionLecturer, devProjects, gpaI, gpaII,  finalGpa};
        csvWriter.writeNext(records, false);
        try {
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return URLConstants.Redirects.SAVE_CASE + "?regNo=" + regNo;

    }

    private String getSavedGpa(StudentDTO studentDTO) throws IOException {
        callJcollibri(studentDTO);
        String[] nextRecord;

        String id ="", finalGpa;
        try (
                Reader reader = Files.newBufferedReader(Paths.get(OUT_CSV_FILE_PATH));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            // Reading Records One by One in a String array

            while ((nextRecord = csvReader.readNext()) != null) {
                id = nextRecord[0];
//                System.out.println("Name : " + nextRecord[0]);
//                System.out.println("Email : " + nextRecord[1]);
//                System.out.println("Phone : " + nextRecord[2]);
//                System.out.println("Country : " + nextRecord[3]);
//                System.out.println("==========================");
            }
        }
        return id; //to show in the view html
        //get it from csv file

    }


    private void callJcollibri(StudentDTO studentDTO) {
        StandardCBRApplication recommender = new Gpa();
        try
        {
            recommender.configure();

            recommender.preCycle();

            CBRQuery query = new CBRQuery();

            GpaDescription hd = new GpaDescription();
            hd.setId(studentDTO.getRegistrationNumber());
            hd.setHoursOfWeeklyStudyI(studentDTO.getHoursOfWeeklyStudyI());
            hd.setHoursOfWeeklyStudyII(studentDTO.getHoursOfWeeklyStudyII());
            hd.setPriorKnowledge(studentDTO.getPriorKnowledge());
            hd.setDevelopedProjects(studentDTO.getDevelopedProjects());
            hd.setGpaYearI(studentDTO.getGpaYearI());
            hd.setGpaYearII(studentDTO.getGpaYearII());
            hd.setInteractionWithLecturer(studentDTO.getInteractionWithLecturer());
            hd.setPreferredArea(new Instance("Oracle"));
            query.setDescription(hd);

            recommender.cycle(query);

            recommender.postCycle();

        } catch (Exception e)
        {
            //org.apache.commons.logging.LogFactory.getLog(Gpa.class).error(e);
            e.printStackTrace();

        }
    }
}
