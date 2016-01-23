/*
 * @author
 * 
 * Harish Fulara(2014143)
 * Anant Mittal(2014015)
 *
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Form3")
public class Form3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR = "PhDAdmissionFiles";
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BufferedWriter writer = null;
		BufferedReader reader = null;
		
		String savePath = System.getProperty("user.home") + File.separator + SAVE_DIR;
		String openPath = System.getProperty("user.home") + File.separator + SAVE_DIR + File.separator + "temp";
	   
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) 
        {
            fileSaveDir.mkdir();
        }
        
        savePath = savePath + File.separator + "Final";
        
        File fileTempDir = new File(savePath);
        if (!fileTempDir.exists()) 
        {
            fileTempDir.mkdir();
            writer = new BufferedWriter(new FileWriter(savePath + File.separator + "eno.txt"));
			writer.write("0");
			writer.close();
			writer = new BufferedWriter(new FileWriter(savePath + File.separator + "email.txt"));
			writer.close();
			writer = new BufferedWriter(new FileWriter(savePath + File.separator + "database.txt"));
			writer.close();
        }
        
        reader = new BufferedReader(new FileReader(savePath + File.separator + "eno.txt"));
		
		String str = reader.readLine();
		int enrollment_no = Integer.valueOf(str);
		
		enrollment_no++;
		
		writer = new BufferedWriter(new FileWriter(savePath + File.separator + "eno.txt"));
		writer.write(String.valueOf(enrollment_no));
		
		reader.close();
		writer.close();
        
		String eno = "PhD2015" + String.valueOf(enrollment_no);
		String read = null;
		
		reader = new BufferedReader(new FileReader(openPath + File.separator + "temp1.txt"));
		writer = new BufferedWriter(new FileWriter(savePath + File.separator + "database.txt", true));
		
		writer.write(eno + ";");
		
		while((read = reader.readLine()) != null)
		{
			writer.write(read + ";");
		}
		
		reader.close();
		
		reader = new BufferedReader(new FileReader(openPath + File.separator + "temp2.txt"));
		
		while((read = reader.readLine()) != null)
		{
			writer.write(read + ";");
		}
		
		String date = new SimpleDateFormat("MM-dd-yyyy hh:mm").format(new Date());
		writer.write(date);
		writer.write("\n");
		
		reader.close();
		writer.close();
		
		writer = new BufferedWriter(new FileWriter(savePath + File.separator + "email.txt", true));
		
		writer.write(GoogleResponse.email + ":" + eno + "\n");
		
		writer.close();
		
		response.sendRedirect("/PhDAdmission_Part2/formSubmitted.html");
	}
}
