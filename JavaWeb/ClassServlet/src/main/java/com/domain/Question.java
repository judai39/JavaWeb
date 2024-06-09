package com.domain;

public class Question {
	private Integer id;
	private String topic;
	private Boolean answer;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public Boolean getAnswer() {
		return answer;
	}
	public void setAnswer(Boolean answer) {
		this.answer = answer;
	}
	public Question() {
		super();
	}
	public Question(Integer id, String topic, Boolean answer) {
		super();
		this.id = id;
		this.topic = topic;
		this.answer = answer;
	}
}
