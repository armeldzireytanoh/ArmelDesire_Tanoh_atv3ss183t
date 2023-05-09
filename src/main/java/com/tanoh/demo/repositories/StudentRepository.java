package com.tanoh.demo.repositories;

import com.tanoh.demo.entities.Classroom;
import com.tanoh.demo.entities.Student;

import com.tanoh.demo.entities.Teacher;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> , JpaSpecificationExecutor<Student> {

    default Page<Student> searchSpecification(Classroom classroom, Teacher teacher, Pageable pageable){
        return findAll(((root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if(Objects.nonNull(classroom)){
                predicates.add(cb.equal(root.get("classroom"), classroom));
            }
            if(Objects.nonNull(teacher)){
                predicates.add(cb.equal(root.get("teacher"), teacher));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        }),pageable);
    }

}
