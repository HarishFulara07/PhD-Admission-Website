/*
 * @author
 * 
 * Harish Fulara(2014143)
 * Anant Mittal(2014015)
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@WebServlet("/GoogleResponseViewForm")
public class GoogleResponseViewForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String email = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try 
		{
			String code = request.getParameter("code");
			String posturl = "code=" + code
					+ "&client_id=1087657363483-b4v772aqoffrmtqes4q4ii70ntg7if9q.apps.googleusercontent.com"
					+ "&client_secret=t7-dSmOcu_iUTHcdw3MFs7zd"
					+ "&redirect_uri=http://localhost:8080/PhDAdmission_Part2/GoogleResponseViewForm"
					+ "&grant_type=authorization_code";

			// post parameters
			URL url = new URL("https://accounts.google.com/o/oauth2/token");
			URLConnection urlConn = url.openConnection();
			urlConn.setDoOutput(true);
			OutputStreamWriter writer = new OutputStreamWriter(urlConn.getOutputStream());
			writer.write(posturl);
			writer.flush();

			// get output in outputString
			String line, outputString = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
			while ((line = reader.readLine()) != null) {
				outputString += line;
			}

			// get Access Token
			JsonObject json = (JsonObject) new JsonParser().parse(outputString);
			String access_token = json.get("access_token").getAsString();

			// get User Info
			url = new URL("https://www.googleapis.com/oauth2/v1/userinfo?access_token=" + access_token);
			urlConn = url.openConnection();
			outputString = "";
			reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
			while ((line = reader.readLine()) != null) {
				outputString += line;
			}

			// Convert JSON response into Pojo class
			
			GooglePojo data = new Gson().fromJson(outputString, GooglePojo.class);
			email = data.getEmail();
			//System.out.println(email);
			writer.close();
			reader.close();
			
			//For successful access
			response.sendRedirect("/PhDAdmission_Part2/View");

		} 
		catch (MalformedURLException e) 
		{
			response.sendRedirect("/PhDAdmission_Part2/UserLogin");
		}
		catch (ProtocolException e) 
		{
			response.sendRedirect("/PhDAdmission_Part2/UserLogin");
		} catch (IOException e) 
		{
			//For denied access
			response.sendRedirect("/PhDAdmission_Part2/UserLogin");
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
