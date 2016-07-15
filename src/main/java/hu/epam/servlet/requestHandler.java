package hu.epam.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
		response.getWriter().println(request.getAttribute("answer"));
		TestController tc = new TestController();
		tc.serveRequest(request, response);
	}
}
