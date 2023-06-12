package com.example.ProjectOne.Controller;

import com.example.ProjectOne.Model.Students;
import com.example.ProjectOne.Service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/Name/{Name}")
    public List<Students> Studentbyname(
            @PathVariable("Name") String Name
    ){
       return Sservice.studentbyname(Name);
    }

    @PostMapping("/Add")
    public void addstudents(@RequestBody Students Student1){
        Sservice.addstudents(Student1);

    }
    @DeleteMapping("/Delete/All")
    public void deletestudents(){
        Sservice.deleteall();
    }

    @DeleteMapping("/Delete/{ID}")
    public void deletestudentbyID(
            @PathVariable("ID") int ID){
        Sservice.deleteStudents(ID);
    }
}
