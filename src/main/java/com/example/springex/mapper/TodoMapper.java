package com.example.springex.mapper;

import com.example.springex.domain.TodoVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {

    void insert(TodoVO todoVO);
    List<TodoVO> selectAll();

}
