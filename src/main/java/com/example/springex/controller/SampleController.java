package com.example.springex.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@Log4j2
public class SampleController {
    @GetMapping("/ex1")
    public void ex1(@RequestParam(name = "name" ,defaultValue = "AAA"  ) String name){
        log.info("ex1" + "name :: " + name );
    }

    @GetMapping("/ex2")
    public void ex2(LocalDate localDate){
        log.info("ex2" + "localDate :: " + localDate );
    }

    @GetMapping("/ex3")
    public void ex3(String p1, int p2){
        log.info("p1" + p1 + " ::: " + "p2" + p2);
    }
}
