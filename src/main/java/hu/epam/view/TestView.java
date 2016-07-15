package hu.epam.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.http.HttpServletResponse;

import hu.epam.model.Answer;
import hu.epam.model.TestDataInterface;

public class TestView {
	
	public void generateTestResult(HttpServletResponse response, String textToDisplay) throws IOException{
		PrintWriter out = response.getWriter(); 
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel=\"stylesheet\" href=\"result-style.css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"result\">" + textToDisplay + "</div>");
		out.println("<form action=\"/WebApp\">" + 
			    "<input type=\"submit\" value=\"New question!\">" + 
			    "</form>");
		out.println("</body>");
		out.println("</html>");
	}
	
	public void generateNormalView(TestDataInterface testData, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel=\"stylesheet\" href=\"question-style.css\">");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<div class=\"question\">"+testData.getText()+"</div>");
		Iterator<Answer> it = testData.getAnswers().iterator();
		out.println("<form>");
		while(it.hasNext()){
			String answer = ((Answer)it.next()).getText();
			out.println("<input type=\"radio\" name=\"answer\" value=\"" + answer +"\">" + answer + "<br>");
		}
		out.println("<input type=\"hidden\" name=\"questionId\" value=\"" + testData.getId() + "\" >");
		out.println("<input type=\"submit\" class=\"submitButton\" value=\"Submit answer\">");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
		
	}
	
}
