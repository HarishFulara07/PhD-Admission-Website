/*
 * @author
 * 
 * Harish Fulara(2014143)
 * Anant Mittal(2014015)
 *
 */
 
import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
 
@WebServlet("/UploadSOP")

@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*10,      // 10MB
                 maxRequestSize=1024*1024*50)   // 50MB

public class UploadSOP extends HttpServlet {
 
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR = "PhDAdmissionFiles";
    
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String savePath = System.getProperty("user.home") + File.separator + SAVE_DIR;
       
        File fileSaveDir = new File(savePath);
        
        if (!fileSaveDir.exists()) 
        {
            fileSaveDir.mkdir();
        }
        
        savePath = savePath + File.separator + "SOP";
        File CVSaveDir = new File(savePath);
        
        if (!CVSaveDir.exists()) 
        {
            CVSaveDir.mkdir();
        }
         
        for (Part part : request.getParts()) 
        {
            String fileName = extractFileName(part);
            part.write(savePath + File.separator + fileName);
        }
        
        request.getRequestDispatcher("/form.html").include(request, response);
    }
    
    private String extractFileName(Part part) 
    {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) 
        {
            if (s.trim().startsWith("filename")) 
            {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }
}
