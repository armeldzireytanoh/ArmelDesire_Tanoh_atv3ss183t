package com.tanoh.demo.controllers;

import com.tanoh.demo.dto.StudentDto;
import com.tanoh.demo.entities.Student;
import com.tanoh.demo.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/search")
    public ResponseEntity<Page<StudentDto>> searchStudents(@RequestParam(value = "classroom", required = false) String classroom,
                                                           @RequestParam(value = "teacherFirstName", required = false) String teacherFirstName,
                                                           @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                                           @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){

        return ResponseEntity.ok(studentService.searchStudent(classroom, teacherFirstName, page, pageSize));
    }

}
