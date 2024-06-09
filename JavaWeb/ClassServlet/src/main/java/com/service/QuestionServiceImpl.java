package com.service;

import java.util.List;

import com.dao.QuestionDao;
import com.dao.QuestionDaoImpl;
import com.domain.Question;


public class QuestionServiceImpl implements QuestionService {

	private QuestionDao questionDao = new QuestionDaoImpl();
	
	@Override
	public int addQuestion(Question question) {
		return questionDao.addQuestion(question);
	}

	@Override
	public int delQuestion(int id) {
		return questionDao.delQuestion(id);
	}

	@Override
	public int editQuestion(Question question) {
		return questionDao.editQuestion(question);
	}

	@Override
	public Question getQuestionById(int id) {
		return questionDao.getQuestionById(id);
	}

	@Override
	public List<Question> getAllQuestion() {
		return questionDao.getAllQuestion();
	}

}
