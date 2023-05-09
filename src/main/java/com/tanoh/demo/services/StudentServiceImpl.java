package com.tanoh.demo.services;

import com.tanoh.demo.dto.StudentDto;
import com.tanoh.demo.entities.Classroom;
import com.tanoh.demo.entities.Student;
import com.tanoh.demo.entities.Teacher;
import com.tanoh.demo.mapper.StudentMapper;
import com.tanoh.demo.repositories.ClassRoomRepository;
import com.tanoh.demo.repositories.StudentRepository;
import com.tanoh.demo.repositories.TeacherRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@AllArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;
    private final ClassRoomRepository classRoomRepository;
    private final TeacherRepository teacherRepository;

    @Override
    public Page<StudentDto> searchStudent(String classroomName, String teacherfirstName, Integer page, Integer pageSize) {
        Classroom classroom = classRoomRepository.findByName(classroomName);
        Teacher teacher = teacherRepository.findByFirstName(teacherfirstName);
        return studentRepository.searchSpecification(classroom, teacher, PageRequest.of(page, pageSize)).
                map(StudentMapper::mapToDto);
    }

}
