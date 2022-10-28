package com.devbrunorafael.springdataredis.service;

import com.devbrunorafael.springdataredis.model.StudentRedis;
import com.devbrunorafael.springdataredis.repository.StudentRedisRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentRedisService {

    private StudentRedisRepository studentRedisRepository;

    public StudentRedis save(StudentRedis studentRedis){
        return studentRedisRepository.save(studentRedis);
    }

    public List<StudentRedis> listAll(){
        return (List<StudentRedis>) studentRedisRepository.findAll();
    }

    // DATA LOADER JSON
    public void saveData(List<StudentRedis> studentRedisList){
        studentRedisRepository.saveAll(studentRedisList);
    }

}
