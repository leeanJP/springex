package com.example.springex.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class PageResponseDTO<E> {
    private int page;
    private int size;
    private int total;

    //시작 , 끝 페이지 번호
    private int start;
    private int end;

    //이전, 다음 페이지 여부
    private boolean prev;
    private boolean next;

    private List<E> dtoList;

    //builder Builder() 이거를 다른이름으로 네이밍할때 사용함
    @Builder(builderMethodName = "withAll")
    public PageResponseDTO(PageRequestDTO pageRequestDTO
            ,List<E>dtoList, int total){
        this.page = pageRequestDTO.getPage();
        this.size = pageRequestDTO.getSize();

        this.total = total;
        this.dtoList = dtoList;

        //마지막 페이지, 시작 페이지 번호 계산
        this.end = (int)(Math.ceil(this.page / 10.0))*10;
        this.start = this.end - 9;

        int last = (int)(Math.ceil((total/(double)size)));

        this.end = end > last ? last : end;
        this.prev = this.start >1;
        this.next = total > this.end * this.size;


    }


}
