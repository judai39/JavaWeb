package com.service;

import java.util.List;

import com.domain.Question;

public interface QuestionService {
	int addQuestion(Question question);
	int delQuestion(int id);
	int editQuestion(Question question);
	Question getQuestionById(int id);
	List<Question> getAllQuestion();
}
