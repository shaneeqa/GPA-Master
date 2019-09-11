package com.gpa.web.controller;

import com.gpa.engine.dto.StudentDTO;
import com.gpa.engine.jcollibri.Gpa;
import com.gpa.engine.jcollibri.GpaDescription;
import com.gpa.engine.model.Student;
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


    @RequestMapping(value = URLConstants.URLs.INDEX)
    public String index() {
        return URLConstants.Views.INDEX;
    }

    @RequestMapping(value = URLConstants.URLs.NEW_CASE)
    public String newCase() {
        return URLConstants.Views.NEW_CASE;
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

    @GetMapping(value = URLConstants.URLs.SAVE_CASE)
    public String list(@RequestParam String regNo, Model model) {
        model.addAttribute("regNo", regNo);
        return URLConstants.Views.SAVED_CASES;
    }

    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String randomAlphaNumeric(int count) {

        StringBuilder builder = new StringBuilder();

        while (count-- != 0) {

            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());

            builder.append(ALPHA_NUMERIC_STRING.charAt(character));

        }

        return builder.toString();

    }

    @PostMapping(value = URLConstants.URLs.CHECK_CASE)
    public String studentCase(StudentDTO studentDTO){
        Student studentCase = new Student();
        studentCase.setPriorKnowledge(studentDTO.getPriorKnowledge());
        studentCase.setHoursOfWeeklyStudyI(studentDTO.getHoursOfWeeklyStudyI());
        studentCase.setHoursOfWeeklyStudyII(studentDTO.getHoursOfWeeklyStudyII());
        studentCase.setInteractionWithLecturer(studentDTO.getInteractionWithLecturer());
        studentCase.setGPAYearI(studentDTO.getGpaYearI());
        studentCase.setGPAYearII(studentDTO.getGpaYearII());
        studentCase.setDevelopedProjects(studentDTO.getDevelopedProjects());
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

        CSVWriter csvWriter = null;
        try {
            csvWriter = new CSVWriter(new FileWriter(CASES_CSV_FILE_PATH, true));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String regNo = studentCase.getRegistrationNumber();
        String priorKnowledge = studentCase.getPriorKnowledge();
        String hoursI = studentCase.getHoursOfWeeklyStudyI();
        String hoursII = studentCase.getHoursOfWeeklyStudyII();
        String gpaI = studentCase.getGPAYearI().toString();
        String gpaII = studentCase.getGPAYearII().toString();
        String devProjects = studentCase.getDevelopedProjects().toString();
        String interactionLecturer = studentCase.getInteractionWithLecturer();
        String finalGpa = studentCase.getFinalGpa().toString();
        String preferredArea = studentCase.getPreferredArea();
        String gpaClass = "";

        if(studentCase.getFinalGpa() <= 4.0){
            gpaClass = "First Class";
        }
        else if(studentCase.getFinalGpa() < 3.7 && studentCase.getFinalGpa() >= 3.3){
            gpaClass = "Second Class Upper";
        }
        else if(studentCase.getFinalGpa() < 3.3 && studentCase.getFinalGpa() >= 2.7){
            gpaClass = "Second Class Lower";
        }
        else if(studentCase.getFinalGpa() < 2.7 && studentCase.getFinalGpa() >= 2.0){
            gpaClass = "General Pass";
        }
        else if (studentCase.getFinalGpa() < 2.0 && studentCase.getFinalGpa() >= 0.0){
            gpaClass = "Fail";
        }

        String[] records = {regNo, priorKnowledge, hoursI, hoursII, interactionLecturer, devProjects, gpaI, gpaII,  finalGpa, preferredArea, regNo, gpaClass};
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

//get solution GPA from csv file
        String id ="";
        try (
                Reader reader = Files.newBufferedReader(Paths.get(OUT_CSV_FILE_PATH));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            // Reading Records One by One in a String array

            while ((nextRecord = csvReader.readNext()) != null) {
                id = nextRecord[0];
            }
        }
        return id; //to show in the view html


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
            hd.setPreferredArea(new Instance(studentDTO.getPreferredArea()));
            query.setDescription(hd);

            recommender.cycle(query);

            recommender.postCycle();

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
