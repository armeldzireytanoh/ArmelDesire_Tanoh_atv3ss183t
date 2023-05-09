package com.tanoh.demo.services;

import com.tanoh.demo.dto.StudentDto;
import org.springframework.data.domain.Page;

public interface StudentService {

    Page<StudentDto> searchStudent(String classroom, String teacherirstName, Integer page, Integer pageSize);

}
