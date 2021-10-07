package com.example.spring_.commnity.dto;

import com.example.spring_.commnity.Model.User;
import lombok.Data;

@Data
public class QuestionDTO {
    private  Integer id;
    private  String title;
    private String description;
    private long gmt_create;
    private long gmt_modified;
    private String tags;
    private Integer view_count;
    private Integer like_count;
    private  Integer creator;
    private Integer comment_like;
//    question与use关联
    private User user;
}
