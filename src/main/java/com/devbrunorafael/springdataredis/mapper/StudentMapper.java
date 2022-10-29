package com.devbrunorafael.springdataredis.mapper;

import com.devbrunorafael.springdataredis.model.StudentModel;
import com.devbrunorafael.springdataredis.model.StudentRedis;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    @Autowired
    private ModelMapper modelMapper;

    public StudentModel toModel(StudentRedis studentRedis){
        return modelMapper.map(studentRedis, StudentModel.class);
    }

}
