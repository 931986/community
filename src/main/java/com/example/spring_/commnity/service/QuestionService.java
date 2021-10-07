package com.example.spring_.commnity.service;

import com.example.spring_.commnity.Mapper.UserMapper;
import com.example.spring_.commnity.Mapper.questionMapper;
import com.example.spring_.commnity.Model.Question;
import com.example.spring_.commnity.Model.User;
import com.example.spring_.commnity.dto.QuestionDTO;
import kotlin.collections.ArrayDeque;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private questionMapper questionMapper_;
    public List<QuestionDTO> list() {
        List<Question> questions=questionMapper_.list();
        List<QuestionDTO> questionDTOList=new ArrayList<>();

        for( Question question : questions){
            User user=userMapper.findById(question.getCreator());
            QuestionDTO questionDTO=new QuestionDTO();
           BeanUtils.copyProperties(question,questionDTO);  // question装化成questionDTO
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }

        return questionDTOList;

    }
//    实现user 和question两张表关联
}
