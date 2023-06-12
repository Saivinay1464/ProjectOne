package com.example.ProjectOne.Controller;

import com.example.ProjectOne.Model.Students;
import com.example.ProjectOne.Service.StudentsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping ("/Student")

public class StudentController {
    private static Logger log = LoggerFactory.getLogger(StudentController.class);


    @Autowired
    StudentsService Sservice;
    @Operation(description = "This is the Student Details list")
    @ApiResponse(responseCode = "200", description = "All the details of Students is fetched")
    @ApiResponse(responseCode = "400", description = "Unable to fetch the details of Students")
    @GetMapping("/Details")
    public List<Students> studentdetails(){
        log.info("Method for getting student details");
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
