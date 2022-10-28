package com.devbrunorafael.springdataredis.controller;

import com.devbrunorafael.springdataredis.model.StudentRedis;
import com.devbrunorafael.springdataredis.service.StudentRedisService;
import com.devbrunorafael.springdataredis.utils.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudantes")
@Slf4j
public class StudentController {

    @Autowired
    private StudentRedisService studentRedisService;

    @PostMapping("/cadastrar")
    public ResponseEntity<StudentRedis> seveStudent(@RequestBody StudentRedis studentRedis){
        var student = studentRedisService.save(studentRedis);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<StudentRedis>> listAllStudents(){
        var students = studentRedisService.listAll();
        return ResponseEntity.ok(students);
    }


    // DATA LOADER JSON
    @PostMapping("/data")
    public ResponseEntity<?> dataLoader(@RequestBody Data data){
        var sizeForStudents = data.studentRedisList.size();

        if(sizeForStudents > 0){
            log.info("Size: {}", sizeForStudents);
            studentRedisService.saveData(data.studentRedisList);
            return ResponseEntity.status(HttpStatus.OK).body("Save data successful!!!");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Save data error...");
    }
}
