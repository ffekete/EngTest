package hu.epam.controller;

import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.epam.model.TestDataInterface;
import hu.epam.model.TestModel;
import hu.epam.view.TestView;

public class TestController {

	private TestModel testModel;
	
	public void serveRequest(HttpServletRequest request, HttpServletResponse response) throws IOException{
		TestDataInterface question = new TestModel().retrieveOneQuestion();
		new TestView().generateNormalView(question, response);
	}
}
