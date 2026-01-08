package com.santos_caroline.first_spring_app.controller;

import com.santos_caroline.first_spring_app.domain.User;
import com.santos_caroline.first_spring_app.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//essa API vai funcionar apenas com o backend pensando nas regras de negócio da aplicação


@RestController //indica que a classe é um controller REST
// combina @Controller + @ResponseBody
@RequestMapping("/hello-world")

public class HelloWordController {
    @Autowired
    private HelloWorldService helloWorldService;


    @GetMapping //vai responder as requisições GET no endpoint /hello-world
    public String helloWorld() {  //método retorna uma string
       return helloWorldService.helloWorld("Carolis");
    }

    @PostMapping
    public String helloWordPost(@RequestBody User body){
        return "Hello World" + body.getName();
    }
}


