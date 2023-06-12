package com.example.ProjectOne.Repository;

import com.example.ProjectOne.Model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentsRepo extends JpaRepository<Students,Integer>{

    public List<Students> findByName(String Name);
}
