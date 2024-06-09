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

@WebServlet("/add.do")
public class AddQuestionServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    QuestionService questionService=new QuestionServiceImpl();

    public AddQuestionServlet(){
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("add.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        String topic=request.getParameter("topic");
        Boolean answer=Boolean.parseBoolean(request.getParameter("answer"));
        Question question=new Question(null,topic,answer);
        questionService.addQuestion(question);

        List<Question> questions=questionService.getAllQuestion();
        request.setAttribute("questions",questions);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
