/*
 * @author
 * 
 * Harish Fulara(2014143)
 * Anant Mittal(2014015)
 *
 */

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.print("<!DOCTYPE html>" +
				"<html>" + 
				"<head>" +
				"<link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\">" +
				"<link rel=\"stylesheet\" href=\"user_register.css\">" +
				"<title>PhD Admission - Login</title>" +
				"</head>" +
				"<body>" +
				"<div class=\"nav\">" +
				"<div class=\"container\">" +
				"<a href=\"https://www.iiitd.ac.in/\"><img class=\"pull-left\" src=\"iiitd-logo.jpg\" /></a>" +
				"<ul class=\"pull-right\">" +
				"<li><a href=\"#\">FAQ</a></li>" +
				"<li><a href=\"#\">Contact</a></li>" +
				"</ul>" +
				"</div>" +
				"</div>" +
				"<div class = \"container\">" +
				"<div class = \"design\">" +
				"<h2> Admin Login - Google Online Authentication </h2>" +
				"<a href=\"https://accounts.google.com/o/oauth2/auth?scope=email%20profile&response_type=code&state=%2Fprofile&redirect_uri=http://localhost:8080/FinalAPProject/GoogleResponse&client_id=579559240312-utr94hr01g1b2978jg3lcucp2og201td.apps.googleusercontent.com\"><img src=\"sign-in-with-google.png\" id=\"logo\"></a>" +
				"</div>" +
				"</div>" +
				"</body>" +
				"</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
