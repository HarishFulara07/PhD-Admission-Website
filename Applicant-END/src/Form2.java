/*
 * @author
 * 
 * Harish Fulara(2014143)
 * Anant Mittal(2014015)
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Form2")

public class Form2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR = "PhDAdmissionFiles";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String savePath = System.getProperty("user.home") + File.separator + SAVE_DIR;
	   
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) 
        {
            fileSaveDir.mkdir();
        }
        
        savePath = savePath + File.separator + "temp";
        
        File fileTempDir = new File(savePath);
        if (!fileTempDir.exists()) 
        {
            fileTempDir.mkdir();
        }
        
        BufferedWriter writer = new BufferedWriter(new FileWriter(savePath + File.separator + "temp2.txt"));
        
        writer.write(request.getParameter("xboard") + "\n");
        if(request.getParameter("xmark1").compareTo("") != 0)
        {
        	writer.write(request.getParameter("xmark1") + "\n");
        }
        else
        {
        	writer.write(request.getParameter("xmark2") + "\n");
        }
        writer.write(request.getParameter("xyear") + "\n");
        writer.write(request.getParameter("xiiboard") + "\n");
        writer.write(request.getParameter("xiimark") + "\n");
        writer.write(request.getParameter("xiiyear") + "\n");
        writer.write(request.getParameter("degree") + "\n");
        writer.write(request.getParameter("discipline") + "\n");
        writer.write(request.getParameter("collegename") + "\n");
        writer.write(request.getParameter("universityname") + "\n");
        writer.write(request.getParameter("collegecity") + "\n");
        writer.write(request.getParameter("gradstate") + "\n");
        writer.write(request.getParameter("gradyear") + "\n");
        if(request.getParameter("gradmark1").compareTo("") != 0)
        {
        	writer.write(request.getParameter("gradmark1") + "\n");
        }
        else
        {
        	writer.write(request.getParameter("gradmark2") + "\n");
        }
        if(request.getParameter("ece_pref1").compareTo("") != 0)
        {
        	writer.write(request.getParameter("ece_pref1") + "\n");
        	writer.write(request.getParameter("ece_pref2") + "\n");
        	writer.write(request.getParameter("ece_pref3") + "\n");
        	writer.write(request.getParameter("ece_pref4") + "\n");
        }
        else
        {
        	writer.write("" + "\n");
            writer.write("" + "\n");
            writer.write("" + "\n");
            writer.write("" + "\n");
        }
        if(request.getParameter("pgcollege").compareTo("") != 0)
        {
        	writer.write(request.getParameter("pgcollege") + "\n");
        	writer.write(request.getParameter("pgcity") + "\n");
        	writer.write(request.getParameter("pgstate") + "\n");
        	writer.write(request.getParameter("pgdiscipline") + "\n");
        	writer.write(request.getParameter("pgdegree") + "\n");
        	writer.write(request.getParameter("pgthesis") + "\n");
        	writer.write(request.getParameter("pgyear") + "\n");
        }
        else
        {
        	writer.write("" + "\n");
            writer.write("" + "\n");
            writer.write("" + "\n");
            writer.write("" + "\n");
            writer.write("" + "\n");
            writer.write("" + "\n");
            writer.write("" + "\n");
        }
        if(request.getParameter("pgmark1").compareTo("") != 0)
        {
        	writer.write(request.getParameter("pgmark1") + "\n");
        }
        else
        {
        	writer.write(request.getParameter("pgmark2") + "\n");
        }
        if(request.getParameter("otherexam").compareTo("") != 0)
        {
        	writer.write(request.getParameter("otherexam") + "\n");
        	writer.write(request.getParameter("othersubject") + "\n");
        	writer.write(request.getParameter("otheryear") + "\n");
        	writer.write(request.getParameter("otherscore") + "\n");
        	writer.write(request.getParameter("otherrank") + "\n");
        }
        else
        {
        	writer.write("" + "\n");
        	writer.write("" + "\n");
        	writer.write("" + "\n");
        	writer.write("" + "\n");
        	writer.write("" + "\n");
        }
        if(request.getParameter("gatearea").compareTo("") != 0)
        {
        	writer.write(request.getParameter("gatearea") + "\n");
        	writer.write(request.getParameter("gateyear") + "\n");
        	writer.write(request.getParameter("gatemark") + "\n");
        	writer.write(request.getParameter("gatescore") + "\n");
        	writer.write(request.getParameter("gaterank") + "\n");
        }
        else
        {
        	writer.write("" + "\n");
        	writer.write("" + "\n");
        	writer.write("" + "\n");
        	writer.write("" + "\n");
        	writer.write("" + "\n");
        }
        writer.write(request.getParameter("achievement") + "\n");
        
        writer.close();
        
        request.getRequestDispatcher("/form.html").include(request, response);
	}
}
