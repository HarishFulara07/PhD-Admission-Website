/*
 * @author
 * 
 * Harish Fulara(2014143)
 * Anant Mittal(2014015)
 */

package ap.iiitd.project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/View")
public class ViewForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR = "PhDAdmissionFiles";
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String savePath = System.getProperty("user.home") + File.separator + SAVE_DIR + File.separator + "Final";
		BufferedReader reader = null;
		String tmp;
		String eno = null;
		
		reader = new BufferedReader(new FileReader(savePath + File.separator + "email.txt"));
		
		while((tmp = reader.readLine()) != null)
		{
			String str[] = tmp.split(":");
			//System.out.println(str[0]);
			if(str[0].compareToIgnoreCase(GoogleResponseViewForm.email) == 0)
			{
				eno = str[1];
				break;
			}
		}
		
		reader.close();
		//System.out.println(eno);
		if(eno == null)
		{
			response.sendRedirect("/PhDAdmission_Part2/UserLogin");
		}
		else
		{
			response.setContentType("text/html");
			
			PrintWriter out = response.getWriter();
			
			reader = new BufferedReader(new FileReader(savePath + File.separator + "database.txt"));
			
			while((tmp = reader.readLine()) != null)
			{
				String str[] = tmp.split(";");
				if(str[0].compareTo(eno) == 0)
				{
					out.print("<!DOCTYPE html>"
							+ "<html>"
							+ "<head>"
							+ "<link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\">"
							+ "<link rel=\"stylesheet\" href=\"user_register.css\">"
							+ "<title>PhD Admission - Register</title>"
							+ "</head>"
							+ "<body>"
							+ "<div class=\"nav\">"
							+ "<div class=\"container\">"
							+ "<a href=\"https://www.iiitd.ac.in/\"><img class=\"pull-left\" src=\"iiitd-logo.jpg\" /></a>"
							+ "<ul class=\"pull-right\">"
							+ "<li><a href=\"https://www.google.com/accounts/Logout?continue=https://appengine.google.com/_ah/logout?continue=http://localhost:8080/PhDAdmission_Part2/main_page_user.html\">Logout</a></li>"
							+ "<li><a href=\"#\">FAQ</a></li>"
							+ "<li><a href=\"#\">Contact</a></li>"
							+ "</ul>"
							+ "</div>"
							+ "</div>"

							+ "<div class = \"container\">"
							+ "<div class = \"designview\">"
							+ "<h2> Form Details </h2>"
							+ "<div class=\"view\">");
					out.print("<p>Email: " + str[1] +"</p>");
					out.print("<p>Name: " + str[2] +"</p>");
					out.print("<p>Address of Correspondence: " + str[3]);
					if(str[4].compareTo("") != 0)
					{
						out.print(", " + str[4]);
						if(str[5].compareTo("") != 0)
						{
							out.print(", " + str[5] + "</p>");
						}
						else
						{
							out.print("</p>");
						}
					}
					else
					{
						out.print("</p>");
					}
					out.print("<p>Mobile Number: " + str[6] +"</p>");
					out.print("<p>PhD Stream: " + str[7] +"</p>");
					out.print("<p>PhD Area of Preference 1: " + str[8] +"</p>");
					if(str[9].compareTo("") != 0)
					{
						out.print("<p>PhD Area of Preference 2: " + str[9] +"</p>");
					}
					else
					{
						out.print("<p>PhD Area of Preference 2: Null </p>");
					}
					if(str[10].compareTo("") != 0)
					{
						out.print("<p>PhD Area of Preference 3: " + str[10] +"</p>");
					}
					else
					{
						out.print("<p>PhD Area of Preference 3: Null </p>");
					}
					out.print("<p>Gender: " + str[11] +"</p>");
					out.print("<p>Category: " + str[12] +"</p>");
					out.print("<p>Physically Disabled: " + str[13] +"</p>");
					out.print("<p>Date of Birth: " + str[14] +"</p>");
					out.print("<p>Children/War Widows of Defence Personnel killed/Disabled in Action: " + str[15] +"</p>");	
					out.print("<p>Father's Name: " + str[16] +"</p>");	
					out.print("<p>Nationality: " + str[17] +"</p>");	
					out.print("<p>Permanent Address: " + str[18]);
					if(str[4].compareTo("") != 0)
					{
						out.print(", " + str[19]);
						if(str[5].compareTo("") != 0)
						{
							out.print(", " + str[20] + "</p>");
						}
						else
						{
							out.print("</p>");
						}
					}
					else
					{
						out.print("</p>");
					}	
					out.print("<p>Pin Code: " + str[21] +"</p>");	
					out.print("<p>Xth Board: " + str[22] +"</p>");	
					out.print("<p>Xth Marks: " + str[23] +"</p>");	
					out.print("<p>Year of Passing Xth: " + str[24] +"</p>");	
					out.print("<p>XIIth Board: " + str[25] +"</p>");	
					out.print("<p>XIIth Marks: " + str[26] +"</p>");	
					out.print("<p>Year of Passing XIIth: " + str[27] +"</p>");	
					out.print("<p>Degree: " + str[28] +"</p>");	
					out.print("<p>Discipline: " + str[29] +"</p>");	
					out.print("<p>Name of College: " + str[30] +"</p>");	
					out.print("<p>Name of University: " + str[31] +"</p>");	
					out.print("<p>City: " + str[32] +"</p>");
					out.print("<p>State: " + str[33] +"</p>");
					out.print("<p>Year of Graduation: " + str[34] +"</p>");
					out.print("<p>Marks: " + str[35] +"</p>");
					
					if(str[36].compareTo("") != 0)
					{
						out.print("<p>ECE Preference 1: " + str[36] +"</p>");
						out.print("<p>ECE Preference 2: " + str[37] +"</p>");
						out.print("<p>ECE Preference 3: " + str[38] +"</p>");
						out.print("<p>ECE Preference 4: " + str[39] +"</p>");
					}
					else
					{
						out.print("<p>ECE Preference 1: Null </p>");
						out.print("<p>ECE Preference 2: Null </p>");
						out.print("<p>ECE Preference 3: Null </p>");
						out.print("<p>ECE Preference 4: Null </p>");
					}
					
					
					if(str[40].compareTo("") != 0)
					{
						out.print("<p>Name of College: " + str[40] +"</p>");
						out.print("<p>City: " + str[41] +"</p>");
						out.print("<p>State: " + str[42] +"</p>");
						out.print("<p>Discipline: " + str[43] +"</p>");
						out.print("<p>Degree: " + str[44] +"</p>");
						out.print("<p>Thesis Title: " + str[45] +"</p>");
						out.print("<p>Year of Post Graduation: " + str[46] +"</p>");
						out.print("<p>Marks: " + str[47] +"</p>");
					}
					else
					{
						out.print("<p>Name of College: Null</p>");
						out.print("<p>City: Null</p>");
						out.print("<p>State: Null</p>");
						out.print("<p>Discipline: Null</p>");
						out.print("<p>Degree: Null</p>");
						out.print("<p>Thesis Title: Null</p>");
						out.print("<p>Year of Graduation: Null</p>");
						out.print("<p>Marks: NUll</p>");
					}
					
					if(str[48].compareTo("") != 0)
					{
						out.print("<p>Exam Name: " + str[48] +"</p>");
						out.print("<p>Subject: " + str[49] +"</p>");
						out.print("<p>Year: " + str[50] +"</p>");
						out.print("<p>Score: " + str[51] +"</p>");
						out.print("<p>Rank: " + str[52] +"</p>");
					}
					else
					{
						out.print("<p>Exam Name: Null</p>");
						out.print("<p>Subject: Null</p>");
						out.print("<p>Year: Null</p>");
						out.print("<p>Score: Null</p>");
						out.print("<p>Rank: Null</p>");
					}
					
					if(str[53].compareTo("") != 0)
					{
						out.print("<p>Area: " + str[53] +"</p>");
						out.print("<p>Year: " + str[54] +"</p>");
						out.print("<p>Marks: " + str[55] +"</p>");
						out.print("<p>Score: " + str[56] +"</p>");
						out.print("<p>Rank: " + str[57] +"</p>");
					}
					else
					{
						out.print("<p>Area: Null</p>");
						out.print("<p>Year: Null</p>");
						out.print("<p>Marks: Null</p>");
						out.print("<p>Score: Null</p>");
						out.print("<p>Rank: Null</p>");
					}
					
					out.print("<p>Achievements: " + str[58] + "</p>");
					out.print("</div>"
							+ "</div>"
							+ "</div>"
							+ "</body>"
							+ "</html>");
					
					
				}
			}
			
			reader.close();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
