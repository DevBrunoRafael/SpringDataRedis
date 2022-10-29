package com.devbrunorafael.springdataredis.service;

import com.devbrunorafael.springdataredis.mapper.StudentMapper;
import com.devbrunorafael.springdataredis.model.StudentModel;
import com.devbrunorafael.springdataredis.model.StudentRedis;
import com.devbrunorafael.springdataredis.repository.StudentRedisRepository;
import com.devbrunorafael.springdataredis.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@EnableScheduling
public class StudentService {

    private static final long INTERVAL = 1000 * 60;

    @Autowired private StudentRedisService studentRedisService;

    @Autowired private StudentRedisRepository studentRedisRepository;

    @Autowired private StudentRepository studentRepository;

    @Autowired private StudentMapper studentMapper;

    @Scheduled(fixedDelay = INTERVAL)
    public void syncCacheData(){
        log.info("Starting sync...");

        List<StudentRedis> studentsInCache = studentRedisService.listAll();

        if (studentsInCache.isEmpty()){
            log.error("Sync error...");
            log.info("Empty cache!");
        } else {

            List<StudentModel> studentsModel = new ArrayList<>();

            studentsInCache.forEach(studentRedis -> {
                var student = studentMapper.toModel(studentRedis);
                studentsModel.add(student);
            });

            studentRepository.saveAll(studentsModel);
            studentRedisRepository.deleteAll(studentsInCache);

            log.info("Sync successful!");

            var cacheSize = studentRedisRepository.count();
            log.info("Cached records: {}", cacheSize);

            var dataSize = studentRepository.count();
            log.info("Data size: {}", dataSize);
        }

    }

}
