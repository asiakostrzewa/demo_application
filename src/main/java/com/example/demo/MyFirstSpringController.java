package com.example.demo;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class MyFirstSpringController {
    @GetMapping(path = "/hello") //localhost:8080/hello
    private String hello(@RequestParam(value = "name", defaultValue = "World!") String name){
        return "Hello " + name;
    }
    @GetMapping("/favourite/{number}") //http://localhost:8080/favourite/8?name=Asia
    public String hello(@PathVariable("number") int number, @RequestParam(value = "name", required = false) String name) {
        StringBuilder sb = new StringBuilder("Hello");
        if (!StringUtils.isEmpty(name)) {
            sb.append(" ").append(name);
        }
        sb.append(", your favourite number is: ");
        sb.append(String.valueOf(number).matches("\\d+") ? number : "NaN");
        /* jeśli zamiast "int name" w wer.18 będzie "String name"
        sb.append(Objects.nonNull(number) && number.matches("\\d+") ? number : "NaN");*/


        return sb.toString();
    }
}
