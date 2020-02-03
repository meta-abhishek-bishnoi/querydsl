 package com.metacube.jpa.postgres.controller;

 import java.util.List;

 import org.apache.logging.log4j.LogManager;
 import org.apache.logging.log4j.Logger;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.HttpHeaders;
 import org.springframework.http.HttpStatus;
 import org.springframework.http.ResponseEntity;
 import org.springframework.stereotype.Controller;
 import org.springframework.web.bind.annotation.DeleteMapping;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.PathVariable;
 import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.RequestBody;
 import org.springframework.web.bind.annotation.RequestMapping;

 import com.metacube.jpa.postgres.exception.RecordNotFoundException;
 import com.metacube.jpa.postgres.model.Teacher;
 import com.metacube.jpa.postgres.model.pojo.TeacherDetails;
 import com.metacube.jpa.postgres.model.pojo.TeacherPojo;
 import com.metacube.jpa.postgres.service.TeacherService;



 @Controller
 @RequestMapping("/teacher")
 public class TeacherController {
 	@Autowired
    TeacherService service;
     @GetMapping
     public ResponseEntity<List<TeacherPojo>> getAllTeachers() {
         List<TeacherPojo> list = service.getAllTeachers();
 
         return new ResponseEntity<List<TeacherPojo>>(list, new HttpHeaders(), HttpStatus.OK);
     }
 
     @GetMapping("/{id}")
     public ResponseEntity<Teacher> getTeacherById(@PathVariable("id") Long id)
                                                     throws RecordNotFoundException {
     	Teacher entity = service.getTeacherById(id);
         return new ResponseEntity<Teacher>(entity, new HttpHeaders(), HttpStatus.OK);
     }
 
    @PostMapping
     public ResponseEntity<Teacher> createOrUpdateTeacher(@RequestBody Teacher teacher)
                                                     throws RecordNotFoundException {
 	   Teacher updated = service.createOrUpdateTeacher(teacher);
         return new ResponseEntity<Teacher>(updated, new HttpHeaders(), HttpStatus.OK);
     }
 
     @DeleteMapping("/{id}")
     public HttpStatus deleteTeacherById(@PathVariable("id") Long id)
                                                     throws RecordNotFoundException {
         service.deleteTeacherById(id);
         return HttpStatus.FORBIDDEN;
     }
    
 }
