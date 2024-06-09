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

@WebServlet("/edit.do")
public class EditQuestionServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    QuestionService questionService=new QuestionServiceImpl();

    public EditQuestionServlet(){
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Integer id=Integer.parseInt(request.getParameter("id"));
        Question question=questionService.getQuestionById(id);
        request.setAttribute("question",question);
        request.getRequestDispatcher("edit.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        Integer id=Integer.parseInt(request.getParameter("id"));
        String topic=request.getParameter("topic");
        Boolean answer=Boolean.parseBoolean(request.getParameter("answer"));
        Question question=new Question(id,topic,answer);
        questionService.editQuestion(question);

        List<Question> questions=questionService.getAllQuestion();
        request.setAttribute("questions",questions);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
