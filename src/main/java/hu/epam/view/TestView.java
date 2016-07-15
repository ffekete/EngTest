package hu.epam.view;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import hu.epam.model.TestDataInterface;

public class TestView {
	
	public void generateNormalView(TestDataInterface testModel, HttpServletResponse response) throws IOException{
		response.getWriter().println(testModel);
	}
	
}
