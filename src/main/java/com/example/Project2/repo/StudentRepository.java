package com.example.Project2.repo;

import com.example.Project2.Models.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student,Long> {
//    List<Student> findByTitle(String title);
    List<Student> findByfamiliaContains(String familia);
}
