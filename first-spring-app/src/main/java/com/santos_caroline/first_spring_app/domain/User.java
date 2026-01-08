package com.santos_caroline.first_spring_app.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class User {
    //Lombok gera os códigos automáticos
    @Getter
    @Setter
    @AllArgsConstructor

    private String name;
    private String email;
}
