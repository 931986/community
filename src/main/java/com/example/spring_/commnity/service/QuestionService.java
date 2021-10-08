package com.example.spring_.commnity.service;

import com.example.spring_.commnity.Mapper.UserMapper;
import com.example.spring_.commnity.Mapper.questionMapper;
import com.example.spring_.commnity.Model.Question;
import com.example.spring_.commnity.Model.User;
import com.example.spring_.commnity.dto.PaginationDTO;
import com.example.spring_.commnity.dto.QuestionDTO;
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
    public PaginationDTO list(Integer page, Integer size) {
        if(page<1){
            page=1;
        }
        Integer totalCount=questionMapper_.count();
       Integer totalPage;
        if(totalCount%size==0){
            totalPage=totalCount/size;
        }else{
            totalPage=totalCount/size+1;
        }
        if(page>totalPage){
            page=totalPage;
        }

        Integer offset=size*(page-1);
        List<Question> questions=questionMapper_.list(offset,size);

        PaginationDTO paginationDTO= new PaginationDTO();

        List<QuestionDTO> questionDTOList=new ArrayList<>();
        for( Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);  // question装化成questionDTO
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);

        paginationDTO.setPagination(totalPage,page,size);


        return paginationDTO;

    }
//    实现user 和question两张表关联
}
