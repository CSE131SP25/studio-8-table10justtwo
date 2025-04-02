package studio8;

import java.util.Scanner;

public class Quiz {
	private Question[] questions;
	
	public Quiz(Question[] questions) {
		this.questions = questions;
	}
	
	private String getUserAnswer(Scanner in) {
		System.out.print("Please enter your answer: ");
		String out = in.next();
		return out;
	}
	
	public int getTotalPoints() {
		int total = 0;
		for(Question q : questions) {
			total += q.getPoints();
		}
		return total;
	}
	
	public void takeQuiz(Scanner in) {
		int score = 0;
		for(Question q : questions) {
			q.displayPrompt();
			String answer = getUserAnswer(in);
			score += q.checkAnswer(answer);
		}
		System.out.println("You earned " + score + " points");
	}
	
	public static void main(String[] args) {
		Question q1 = new Question("What is 2+2?", "4", 1);
		String[] options = {"Paris", "London", "Berlin", "Madrid"};
		MultipleChoiceQuestion q2 = new MultipleChoiceQuestion(
			"What is the capital of France?", 
			"1", 
			2, 
			options);
		SelectAllQuestion q3 = new SelectAllQuestion(
			"Select all European capitals:", 
			"13", 
			options);
		
		Question[] questions = {q1, q2, q3};
		Quiz quiz = new Quiz(questions);
		
		Scanner scanner = new Scanner(System.in);
		quiz.takeQuiz(scanner);
		scanner.close();
	}
}