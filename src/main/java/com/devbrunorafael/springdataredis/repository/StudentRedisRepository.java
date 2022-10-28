package com.devbrunorafael.springdataredis.repository;

import com.devbrunorafael.springdataredis.model.StudentRedis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRedisRepository extends CrudRepository<StudentRedis, Long> {
}
