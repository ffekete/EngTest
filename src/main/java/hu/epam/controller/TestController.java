package hu.epam.controller;

import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.epam.model.TestData;
import hu.epam.model.TestDataInterface;
import hu.epam.model.TestModel;
import hu.epam.view.TestView;

public class TestController {

	private TestModel testModel;
	
	public void serveNewRequest(HttpServletRequest request, HttpServletResponse response) throws IOException{
		TestDataInterface question = new TestModel().retrieveOneQuestion();
		new TestView().generateNormalView(question, response);
	}
	
	public void evaluateTestResult(String questionId, String answer, HttpServletResponse response) throws IOException{
		TestDataInterface question = new TestModel().retrieveQuestionById(questionId);
		if(question.evaluateAnswer(answer) == true){
			response.getWriter().println("Szép volt!");
		}
		else
		{
			response.getWriter().println("Sajnos nem!");
		}
		response.getWriter().println("<form action=\"/WebApp\">" + 
	    "<input type=\"submit\" value=\"New question!\">" + 
	    "</form>");
	}
}
