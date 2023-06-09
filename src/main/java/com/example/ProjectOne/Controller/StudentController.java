package com.example.ProjectOne.Controller;

import com.example.ProjectOne.Model.Students;
import com.example.ProjectOne.Service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/Student")
public class StudentController {
    @Autowired
    StudentsService Sservice;

    @GetMapping("/Details")
    public List<Students> studentdetails(){
        return Sservice.studentdetails();
    }
}
