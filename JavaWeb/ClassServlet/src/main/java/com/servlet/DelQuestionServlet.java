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
import java.util.List;

@WebServlet("/del.do")
public class DelQuestionServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    private QuestionService questionService=new QuestionServiceImpl();

    public DelQuestionServlet(){
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        response.getWriter().append("Served at:").append(request.getContextPath());
        Integer id=Integer.parseInt(request.getParameter("id"));
        questionService.delQuestion(id);

        List<Question> questions=questionService.getAllQuestion();
        request.setAttribute("questions",questions);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
