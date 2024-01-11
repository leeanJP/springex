package com.example.springex.controller;

import com.example.springex.dto.PageRequestDTO;
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
//    @RequestMapping("/list")
//    public void list(Model model){
//        log.info("todo list");
//        model.addAttribute("dtoList", todoService.getAll());
//    }
    @GetMapping("/list")
    public void list(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model){
        log.info("TodoController list ::"+pageRequestDTO);

        if(bindingResult.hasErrors()){
            pageRequestDTO = PageRequestDTO.builder().build();
        }
        model.addAttribute("responseDTO", todoService.getList(pageRequestDTO));

    }


    //register get
    @GetMapping("/register")
    public void registerGet(){

        log.info("todo registerGet");
    }
    //register post
    @PostMapping("/register")
    public String registerPost(@Valid TodoDTO todoDTO,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes){
        log.info("todo registerPost");
        if(bindingResult.hasErrors()){
            log.info("has errors..");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            log.info(bindingResult);
            return "redirect:/todo/register";
        }
        todoService.register(todoDTO);
        return "redirect:/todo/list";
    }

    @GetMapping({"/read" , "/modify"})
    public void read(Long tno, PageRequestDTO pageRequestDTO, Model model){
        TodoDTO todoDTO = todoService.getOne(tno);
        log.info("todo read :: " + todoDTO);

        model.addAttribute("dto", todoDTO);

    }

    @PostMapping("/remove")
    public String remove(long tno, PageRequestDTO pageRequestDTO,RedirectAttributes redirectAttributes){

        log.info("==========remove : " + tno + " ===========");
        todoService.remove(tno);
        redirectAttributes.addAttribute("page" , 1);
        redirectAttributes.addAttribute("size" , pageRequestDTO.getSize());

        return "redirect:/todo/list";
    }


    @PostMapping("/modify")
    public String modify(@Valid TodoDTO todoDTO, PageRequestDTO pageRequestDTO,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){
        log.info("todo modify" +todoDTO);
        if(bindingResult.hasErrors()){
            log.info("has errors..");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("tno", todoDTO.getTno());
            return "redirect:/todo/modify";
        }
        todoService.modify(todoDTO);
        redirectAttributes.addAttribute("page", pageRequestDTO.getPage());
        redirectAttributes.addAttribute("size", pageRequestDTO.getSize());


        return "redirect:/todo/list";
    }

}
