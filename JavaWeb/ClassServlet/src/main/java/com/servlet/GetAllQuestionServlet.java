package com.servlet;

import com.domain.Question;
import com.service.QuestionService;
import com.service.QuestionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/all.do")
public class GetAllQuestionServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    private QuestionService questionService=new QuestionServiceImpl();

    public GetAllQuestionServlet(){
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        response.getWriter().append("Served at:").append(request.getContextPath());
        List<Question> questions=questionService.getAllQuestion();
        //参数请求设置属性（设置为Questions[]对象，并将名字设置为questions）
        request.setAttribute("questions",questions);
        request.getRequestDispatcher("index.jsp").forward(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
