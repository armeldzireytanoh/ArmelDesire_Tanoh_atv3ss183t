package com.tanoh.demo.mapper;

import com.tanoh.demo.dto.StudentDto;
import com.tanoh.demo.entities.Student;

public interface StudentMapper {

    public static StudentDto mapToDto(Student student){
        StudentDto studentDto = new StudentDto();
        studentDto.setClassroom(student.getClassroom().getName());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setTeacherFirstname(student.getTeacher().getFirstName());
        studentDto.setTeacherLastName(student.getTeacher().getLastName());
        return studentDto;
    }

}
