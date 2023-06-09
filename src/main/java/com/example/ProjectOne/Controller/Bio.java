package com.example.ProjectOne.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Vinay")
public class Bio {
    @GetMapping("/Bio")
    public String vinaybio() {
        return ("This is SaiVinay\n"+ "I am pursuing Masters in Data Science\n" +
                "I will get a job in June");

    }

}
