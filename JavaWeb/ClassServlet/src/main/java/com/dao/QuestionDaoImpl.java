package com.dao;

import com.domain.Question;
import com.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class QuestionDaoImpl implements QuestionDao {
	
	private DBUtil util = DBUtil.getInstance();

	@Override
	public int addQuestion(Question question) {
		util.getConnection();
		int i = util.executeUpdate("insert into question_tbl(topic, answer) values(?, ?)",
				new Object[] {question.getTopic(), question.getAnswer() ? 1 : 0});
		util.close();
		return i;
	}

	@Override
	public int delQuestion(int id) {
		util.getConnection();
		int i = util.executeUpdate("delete from question_tbl where id = ?",
				new Object[] {id});
		util.close();
		return i;
	}

	@Override
	public int editQuestion(Question question) {
		util.getConnection();
		int i = util.executeUpdate("update question_tbl set topic = ?, answer = ? where id = ?",
				new Object[] {question.getTopic(), question.getAnswer() ? 1 : 0, question.getId()});
		util.close();
		return i;
	}

	@Override
	public Question getQuestionById(int id) {
		util.getConnection();
		ResultSet rs = util.executeQuery("select * from question_tbl where id = ?", new Object[] {id});
		Question question = null;
		try {
			if (rs.next()) {
				int qid = rs.getInt("id");
				String topic = rs.getString("topic");
				boolean answer = rs.getInt("answer") == 1;
				question = new Question(qid, topic, answer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		util.close();
		return question;
	}

	@Override
	public List<Question> getAllQuestion() {
		util.getConnection();
		ResultSet rs = util.executeQuery("select * from question_tbl");
		List<Question> questions = new ArrayList<>();
		try {
			while (rs.next()) {
				int id = rs.getInt("id");
				String topic = rs.getString("topic");
				boolean answer = rs.getInt("answer") == 1;
				Question question = new Question(id, topic, answer);
				questions.add(question);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		util.close();
		return questions;
	}

}
