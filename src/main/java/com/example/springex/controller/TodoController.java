package com.example.springex.controller;

import com.example.springex.dto.TodoDTO;
import com.example.springex.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/todo")
@Log4j2
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;
    //list
    @RequestMapping("/list")
    public void list(Model model){
        log.info("todo list");
        model.addAttribute("dtoList", todoService.getAll());
    }

    //register get
    @GetMapping("/register")
    public void registerGet(){

        log.info("todo registerGet");
    }
    //register post
    @PostMapping("/register")
    public String registerPost(TodoDTO todoDTO,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes){
        log.info("todo registerPost");
        if(bindingResult.hasErrors()){
            log.info("1");
            log.info("has errors..");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/todo/register";
        }
        log.info("2");
        todoService.register(todoDTO);
        return "redirect:/todo/list";
    }

    @GetMapping("/read")
    public void read(Long tno, Model model){
        TodoDTO todoDTO = todoService.getOne(tno);
        log.info("todo read :: " + todoDTO);

        model.addAttribute("dto", todoDTO);

    }
}
