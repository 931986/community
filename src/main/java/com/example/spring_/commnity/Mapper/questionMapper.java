package com.example.spring_.commnity.Mapper;

import com.example.spring_.commnity.Model.Question;
import com.example.spring_.commnity.Model.User;
import com.example.spring_.commnity.dto.PaginationDTO;
import com.example.spring_.commnity.dto.QuestionDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface questionMapper {
    @Insert("insert into QUESTION (TITLE,DESCRIPTION,GMT_CREATE,GMT_MODIFIED,CREATOR,TAGS) values (#{title},#{description},#{gmt_create},#{gmt_modified},#{creator},#{tags})")
     void create(Question question);
    @Select("Select * from QUESTION limit #{offset} , #{size}  ")

    List<Question> list(@Param(value = "offset") Integer offset,  @Param(value = "size") Integer size);
    @Select("Select count(1) from QUESTION ")
    Integer count();

    @Select("Select * from QUESTION  where CREATOR=#{userId}  limit #{offset} , #{size}  ")
    List<Question> list_(@Param(value = "userId")Integer userId, @Param(value = "offset")Integer offset, @Param(value = "size")Integer size);

    @Select("Select count(1) from QUESTION where CREATOR= #{userId} ")
    Integer countByUserId(@Param(value = "userId")Integer userId);


    @Select("Select * from QUESTION  where ID=#{id}  ")
    Question getById(@Param(value = "id")Integer id);
}
