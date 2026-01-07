package com.santos_caroline.first_spring_app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//essa API vai funcionar apenas com o backend pensando nas regras de negócio da aplicação

@RestController //indica que a classe é um controller REST
// combina @Controller + @ResponseBody
@RequestMapping("/hello-world")

public class HelloWordController {
    @GetMapping //vai responder as requisições GET no endpoint /hello-world
    public String helloWorld() {  //método retorna uma string
       return "Hello World";
    }

}
