package com.devbrunorafael.springdataredis.utils;

import com.devbrunorafael.springdataredis.model.StudentRedis;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Data implements Serializable {
    public List<StudentRedis> studentRedisList = new ArrayList<>();
}
