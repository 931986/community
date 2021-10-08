package com.example.spring_.commnity.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private Boolean showPrevious;
    private Boolean showFirstPage;
    private Boolean showNext;
    private Boolean showEndPage;
    private Integer currentPage;
    private  List<Integer> pages=new ArrayList<>();
    private Integer totalPage;


    public void setPagination(Integer totalPage, Integer page, Integer size) {

   this.totalPage=totalPage;



        this.currentPage=page;
//        是否展示上下一页的button
        pages.add(page);
       for(int i=1;i<3;i++){
         if(page-i>0){
             pages.add(0,page-i);
           }
         if(page+i<=totalPage){
             pages.add(page+i);
         }
       }

            showPrevious= page != 1;
              showNext= page !=totalPage ;
//              是否展示首页和最后一页的选择按钮
        showFirstPage= !pages.contains(1);
        showEndPage= !pages.contains(totalPage);



    }
}
