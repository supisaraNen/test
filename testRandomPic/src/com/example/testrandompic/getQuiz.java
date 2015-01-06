package com.example.testrandompic;

public class getQuiz {
	private int id;
	private String quiz;
	private int answer;
	
	public getQuiz(int id,String quiz,int answer){
		this.id = id;
		this.quiz = quiz;
		this.answer = answer;
	}
	
	public int getID(){
		return id;
	}
	
	public String getQuiz(){
		return quiz;
	}
	
	public int getAnswer(){
		return answer;
	}
}

