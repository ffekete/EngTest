package 	hu.epam.servlet;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.epam.controller.TestController;

@WebServlet(name = "getHandler",  
			urlPatterns = "/WebApp"	)
public class requestHandler extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		String answer = request.getParameter("answer");
		String questionId = request.getParameter("questionId");
		TestController tc = new TestController();
		
		if(answer == null){
			tc.serveNewRequest(request, response);
		}
		else
		{
			tc.evaluateTestResult(questionId, answer, response);
		}
	}
}
