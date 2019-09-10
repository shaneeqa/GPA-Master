package com.gpa.web.controller;

import com.gpa.engine.dto.AdminDTO;
import com.gpa.engine.model.Admin;
import com.gpa.web.constants.URLConstants;
import com.opencsv.CSVReader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.gpa.web.constants.FileConstraints.USERS_CSV_FILE_PATH;

@Controller
public class AdminController {

    @RequestMapping(value = URLConstants.URLs.LOG_IN)
    public String admin() {
        return URLConstants.Views.LOG_IN;
    }

    @PostMapping(value = URLConstants.URLs.LOG_IN)
    public String login(AdminDTO adminDTO){
        try {
            checkAuthentication(adminDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return URLConstants.Views.ADMIN;
    }
    
    private boolean checkAuthentication(AdminDTO adminDTO) throws IOException {
        String id = adminDTO.getAdminId();
        String password = adminDTO.getPassword();
        boolean alert = false;
        try (
                Reader reader = Files.newBufferedReader(Paths.get(USERS_CSV_FILE_PATH));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            // Reading Records One by One in a String array

            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                if(id.equals(nextRecord[0]) && password.equals(nextRecord[1])){
                    alert = true;
                }
                else{
                    alert = false;
                }

            }
        }
        return alert;
    }

}
