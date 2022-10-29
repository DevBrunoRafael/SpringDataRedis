package com.devbrunorafael.springdataredis.repository;

import com.devbrunorafael.springdataredis.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, String> {
}
