 package com.metacube.jpa.postgres.controller;

 import java.util.List;

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
 import com.metacube.jpa.postgres.model.Department;
 import com.metacube.jpa.postgres.model.pojo.DepartmentPojo;
 import com.metacube.jpa.postgres.model.pojo.TeacherDetails;
 import com.metacube.jpa.postgres.service.DepartmentService;



 @Controller
 @RequestMapping("/department")
 public class DepartmentController {
 	@Autowired
     DepartmentService service;
 
     @GetMapping
     public ResponseEntity<List<DepartmentPojo>> getAllDepartments() {
         List<DepartmentPojo> list = service.getAllDepartments();
 
         return new ResponseEntity<List<DepartmentPojo>>(list, new HttpHeaders(), HttpStatus.OK);
     }
 
     @GetMapping("/{id}")
     public ResponseEntity<DepartmentPojo> getDepartmentById(@PathVariable("id") Long id)
                                                     throws RecordNotFoundException {
     	DepartmentPojo entity = service.getDepartmentById(id);
 
         return new ResponseEntity<DepartmentPojo>(entity, new HttpHeaders(), HttpStatus.OK);
     }
 
     @PostMapping
     public ResponseEntity<Department> createOrUpdateDepartment(@RequestBody Department department)
                                                     throws RecordNotFoundException {
 	   Department updated = service.createOrUpdateDepartment(department);
         return new ResponseEntity<Department>(updated, new HttpHeaders(), HttpStatus.OK);
     }
 
     @DeleteMapping("/{id}")
     public HttpStatus deleteDepartmentById(@PathVariable("id") Long id)
                                                     throws RecordNotFoundException {
         service.deleteDepartmentById(id);
         return HttpStatus.FORBIDDEN;
     }
    
     @PostMapping(path="/get-teachers",consumes = "application/json")
 	 public ResponseEntity<List<TeacherDetails>> getTecherListByDepartmentName()
 	                                                    throws RecordNotFoundException {
 		   List<TeacherDetails> teacher = service.getTeachersListOfDepartment();
 		   return new ResponseEntity<List<TeacherDetails>>(teacher, new HttpHeaders(), HttpStatus.OK);
 	 }
 }
