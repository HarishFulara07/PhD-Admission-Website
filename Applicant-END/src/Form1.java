/*
 * @author
 * 
 * Harish Fulara(2014143)
 * Anant Mittal(2014015)
 *
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

@WebServlet("/Form1")
public class Form1 extends HttpServlet {
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
        
        BufferedWriter writer = new BufferedWriter(new FileWriter(savePath + File.separator + "temp1.txt"));
        
        writer.write(request.getParameter("email") + "\n");
        writer.write(request.getParameter("name") + "\n");
        writer.write(request.getParameter("c_addr1") + "\n");
        if(request.getParameter("c_addr2").compareTo("") == 0)
        {
        	writer.write("" + "\n");
        }
        else
        {
        	writer.write(request.getParameter("c_addr2") + "\n");
        }
        if(request.getParameter("c_addr3").compareTo("") == 0)
        {
        	writer.write("" + "\n");
        }
        else
        {
        	writer.write(request.getParameter("c_addr3") + "\n");
        }
        writer.write(request.getParameter("mobile") + "\n");
        writer.write(request.getParameter("stream") + "\n");
        writer.write(request.getParameter("pref1") + "\n");
        if(request.getParameter("pref2").compareTo("") == 0)
        {
        	writer.write("" + "\n");
        }
        else
        {
        	writer.write(request.getParameter("pref2") + "\n");
        }
        if(request.getParameter("pref3").compareTo("") == 0)
        {
        	writer.write("" + "\n");
        }
        else
        {
        	writer.write(request.getParameter("pref3") + "\n");
        }
        writer.write(request.getParameter("gender") + "\n");
        writer.write(request.getParameter("category") + "\n");
        writer.write(request.getParameter("pd") + "\n");
        writer.write(request.getParameter("dob") + "\n");
        writer.write(request.getParameter("war") + "\n");
        writer.write(request.getParameter("father_name") + "\n");
        writer.write(request.getParameter("nationality") + "\n");
        writer.write(request.getParameter("p_addr1") + "\n");
        if(request.getParameter("p_addr2").compareTo("") == 0)
        {
        	writer.write("" + "\n");
        }
        else
        {
        	writer.write(request.getParameter("p_addr2") + "\n");
        }
        if(request.getParameter("p_addr3").compareTo("") == 0)
        {
        	writer.write("" + "\n");
        }
        else
        {
        	writer.write(request.getParameter("p_addr3") + "\n");
        }
        writer.write(request.getParameter("pin") + "\n");
               
        writer.close();
        
        request.getRequestDispatcher("/form.html").include(request, response);
        
	}
}
