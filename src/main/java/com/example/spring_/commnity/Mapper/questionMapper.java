package com.example.spring_.commnity.Mapper;

import com.example.spring_.commnity.Model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface questionMapper {
    @Insert("insert into QUESTION (TITLE,DESCRIPTION,GMT_CREATE,GMT_MODIFIED,CREATOR,TAGS) values (#{title},#{description},#{gmt_create},#{gmt_modified},#{creator},#{tags})")
     void create(Question question);
}
