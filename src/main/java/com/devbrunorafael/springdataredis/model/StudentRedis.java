package com.devbrunorafael.springdataredis.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("student")
public class StudentRedis implements Serializable {

    @Id
    @Indexed
    private String cpf;
    private String nome;
    private String telefone;

}
