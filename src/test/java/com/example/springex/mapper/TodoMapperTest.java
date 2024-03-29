package com.example.springex.mapper;

import com.example.springex.domain.TodoVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
class TodoMapperTest {

    @Autowired(required = false)
    private TodoMapper todoMapper;

    @Test
    void insert() {

        TodoVO todoVO =TodoVO.builder()
                .title("테스트 1")
                .dueDate(LocalDate.of(2024,01,10))
                .writer("관리자1")
                .build();

        todoMapper.insert(todoVO);

    }
}