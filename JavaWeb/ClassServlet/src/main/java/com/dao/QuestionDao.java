package com.dao;

import java.util.List;

import com.domain.Question;

public interface QuestionDao {
	int addQuestion(Question question);
	int delQuestion(int id);
	int editQuestion(Question question);
	Question getQuestionById(int id);
	List<Question> getAllQuestion();
}
