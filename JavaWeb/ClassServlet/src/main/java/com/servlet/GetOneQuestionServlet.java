package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.Question;
import com.google.gson.Gson;

import com.service.QuestionService;
import com.service.QuestionServiceImpl;

@WebServlet("/one.do")
//ʹ��ע��ʽ����,web.xml�ļ���version�汾Ҫ����3.0,ͬʱmatadata-complete����ֵΪfalse
public class GetOneQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QuestionService questionService = new QuestionServiceImpl();

    public GetOneQuestionServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		List<Question> questions = questionService.getAllQuestion();
		Gson gson = new Gson();
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().println(gson.toJson(questions));
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
