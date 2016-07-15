package hu.epam.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.http.HttpServletResponse;

import hu.epam.model.Answer;
import hu.epam.model.TestDataInterface;

public class TestView {
	
	public void generateTestResult(HttpServletResponse response, String textToDisplay) throws IOException{
		response.getWriter().println(textToDisplay);
		response.getWriter().println("<form action=\"/WebApp\">" + 
			    "<input type=\"submit\" value=\"New question!\">" + 
			    "</form>");
	}
	
	public void generateNormalView(TestDataInterface testData, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		out.println("<div class=\"question\">"+testData.getText()+"</div>");
		Iterator<Answer> it = testData.getAnswers().iterator();
		out.println("<form>");
		while(it.hasNext()){
			String answer = ((Answer)it.next()).getText();
			out.println("<input type=\"radio\" name=\"answer\" value=\"" + answer +"\">" + answer + "</input><br>");
		}
		out.println("<input type=\"hidden\" name=\"questionId\" value=\"" + testData.getId() + "\" ></input>");
		out.println("<input type=\"submit\" class=\"submitButton\" value=\"Submit answer\"></input>");
		out.println("</form>");
		
		
	}
	
}
