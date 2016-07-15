package hu.epam.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import hu.epam.model.TestDataInterface;
import hu.epam.model.TestModel;
import hu.epam.view.TestView;

public class TestController {
	
	public void serveNewRequest(HttpServletRequest request, HttpServletResponse response) throws IOException{
		TestDataInterface question = new TestModel().retrieveOneQuestion();
		new TestView().generateNormalView(question, response);
	}
	
	public void evaluateTestResult(String questionId, String answer, HttpServletResponse response) throws IOException{
		TestDataInterface question = new TestModel().retrieveQuestionById(questionId);
		TestView tw = new TestView();
		String textToDisplay = "";
		if(question.evaluateAnswer(answer) == true){
			textToDisplay = "Szép volt!";
		}
		else
		{
			textToDisplay = "Sajnos nem sikerült!";
		}
		
		tw.generateTestResult(response, textToDisplay);
	}
}
