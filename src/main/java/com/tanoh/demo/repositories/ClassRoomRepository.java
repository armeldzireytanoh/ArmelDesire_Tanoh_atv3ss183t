package com.tanoh.demo.repositories;

import com.tanoh.demo.entities.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

public interface ClassRoomRepository extends JpaRepository<Classroom, Long>, JpaSpecificationExecutor<Classroom> {

    Classroom findByName(String name);

}
