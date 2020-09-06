package com.example.springboot.controller;

import com.example.springboot.model.Student;
import com.example.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class StudentRestController {

    @Autowired
    StudentService studentService;

    @RequestMapping(path = "test")
    public String test(){
        return "Hello World";
    }

    @RequestMapping(path = "/student",method = RequestMethod.POST)
    public Student save(@RequestBody Student student){
       return studentService.save(student);
    }


    @RequestMapping(path = "/student",method = RequestMethod.GET)
    public ResponseEntity<Student> fetchStudenById(@RequestParam int id){
        Student student=studentService.fetchStudentById(id);
        if(student ==null){
           return ResponseEntity.notFound().build();
        }else {
          return   ResponseEntity.ok().body(student);
        }
    }
}
