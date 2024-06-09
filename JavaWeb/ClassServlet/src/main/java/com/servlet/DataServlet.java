package com.servlet;

import com.domain.Question;
import com.google.gson.Gson;
import com.service.QuestionService;
import com.service.QuestionServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DataServlet {
    private QuestionService questionService=new QuestionServiceImpl();

    public DataServlet(){
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Question> questions=questionService.getAllQuestion();
        Gson gson = new Gson();
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().print(gson.toJson(questions));
    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
        doGet(request,response);
    }
}
