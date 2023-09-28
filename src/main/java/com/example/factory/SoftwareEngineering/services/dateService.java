package com.example.factory.SoftwareEngineering.services;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
@Service
public class dateService {
    public String getDate(){
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = currentDate.format(formatter);
        return formattedDate;
    }
}
