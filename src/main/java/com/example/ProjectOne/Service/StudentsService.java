package com.example.ProjectOne.Service;

import com.example.ProjectOne.Model.Students;
import com.example.ProjectOne.Repository.StudentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsService {
    @Autowired
    StudentsRepo repo;

    public List<Students> studentdetails(){
        return repo.findAll();
    }
}
