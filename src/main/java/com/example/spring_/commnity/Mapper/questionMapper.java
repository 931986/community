package com.example.spring_.commnity.Mapper;

import com.example.spring_.commnity.Model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface questionMapper {
    @Insert("insert into QUESTION (TITLE,DESCRIPTION,GMT_CREATE,GMT_MODIFIED,CREATOR,TAGS) values (#{title},#{description},#{gmt_create},#{gmt_modified},#{creator},#{tags})")
     void create(Question question);
    @Select("Select * from QUESTION limit #{offset},#{size} ")
    List<Question> list(@Param(value = "offset") Integer offset,  @Param(value = "size") Integer size);
    @Select("Select count(1) from QUESTION ")
    Integer count();
}
