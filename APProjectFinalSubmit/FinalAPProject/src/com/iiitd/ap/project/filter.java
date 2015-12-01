/*
 * @author
 
 * Harish(2014143)
 * Anant(2014015)
 */

package com.iiitd.ap.project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/filter")
@SuppressWarnings("serial")
public class filter extends HttpServlet {
	int flag1 = 0; // flag for date of birth error
	int flag2 = 0; // flag for x percentag
	int flag3 = 0; // flag for xii percentage
	int flag4 = 0; // flag for graduation percentage
	int flag5 = 0; // flag for post graduation percentage
	int flag6 = 0; // flag for gate score percentage
	ArrayList<Person> personData = new ArrayList<Person>();
	private static final String SAVE_DIR = "PhDAdmissionFiles";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.print("<!DOCTYPE html>" + "<html>" + "<head>" + "<link rel=\"stylesheet\" href=\"bootstrap.css\">"
				+ "<link rel=\"stylesheet\" href=\"main.css\">" + "<link rel=\"stylesheet\" href=\"form.css\">"

				+ "<title>PhD Admissions IIITD</title>" + "</head>" +

		"<body>" + "<div class=\"nav\">" + "<div class=\"container\" id=\"custom-link\">"
				+ "<a href=\"https://www.iiitd.ac.in/\"><img class=\"pull-left\" src=\"iiitd-logo.jpg\" />" + "</a>"
				+ "<ul class=\"pull-left\">" + "<li><a href=\"index.html\">BACK</li>" + "</ul>"
				+ "<ul class=\"pull-right\">"

				+ "<li><a href=\"#\">FAQ</a></li>" + "<li><a href=\"#\">Contact</a></li>"

				+ "</ul>" + "<ul class=\"pull-center\">" + "<h7 style=\"color: white\">abc</h7>"
				+ "<h3 style=\"color: black\">Filtered Entries</h3>" + "</ul>"

				+ "</div>" + "</div>" + "<div class=\"nav\">" + "<div class=\"container\">" +

		"</div>" + "</div>" + "<div class=\"mytable\">" + "<table class=\"table\">" + "<thead>" + "<tr id=\"coltitle\">"
				+ "<th>Name</th>" + "<th>Enrollment Number</th>" + "<th>Link to Details</th>" + "</tr>" + "</thead>");

		for (Person p : personData) {
			out.print("<tr>" + "<td>" + p.getname() + "</td>" + "<td>" + p.getenrollmentNumber() + "</td>" + "<td>"
					+ "<form action=\"ViewDetails\" method=\"post\">" + "<input type=\"hidden\" name=\"ID\" value=\""
					+ p.getenrollmentNumber() + "\">" + "<input type=\"submit\" value=\"Link\">" + "</form>" + "</td>"
					+ "</tr>");
		}
		out.print("</table>" + "</div>" + "</body>" + "</html>");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		filterResult(request, response);
		doGet(request, response);
	}

	void firstCheckForInvalidInput(HttpServletRequest request, HttpServletResponse response) {

		if (request.getParameter("dobradiobutton") != null && request.getParameter("dobdatepicker") != null) {
		} else if (request.getParameter("dobradiobutton") == null && request.getParameter("dobdatepicker") == null) {
		} else {
			flag1 = 1;

		}
		if (request.getParameter("xboardmarks") != null && !request.getParameter("xpercentage").isEmpty()) {
			Double per = Double.parseDouble(request.getParameter("xpercentage"));
			if (0 >= per || per >= 100) {
				flag2 = 1;

			}

		} else if (request.getParameter("xboardmarks") == null && request.getParameter("xpercentage").isEmpty()) {

		} else {
			flag2 = 1;
		}
		if (request.getParameter("xiiboardmarks") != null && !request.getParameter("xiipercentage").isEmpty()) {
			Double per = Double.parseDouble(request.getParameter("xiipercentage"));
			if (0 >= per || per >= 100) {
				flag3 = 1;

			}

		} else if (request.getParameter("xiiboardmarks") == null && request.getParameter("xiipercentage").isEmpty()) {

		} else {
			flag3 = 1;
		}
		if (request.getParameter("graduationmarks") != null
				&& !request.getParameter("graduationpercentage").isEmpty()) {
			Double per = Double.parseDouble(request.getParameter("graduationpercentage"));
			if (0 >= per || per >= 100) {
				flag4 = 1;

			}

		} else if (request.getParameter("graduationmarks") == null
				&& request.getParameter("graduationpercentage").isEmpty()) {

		} else {
			flag4 = 1;
		}
		if (request.getParameter("postgraduationboardmarks") != null
				&& !request.getParameter("postgraduationpercentage").isEmpty()) {
			Double per = Double.parseDouble(request.getParameter("postgraduationpercentage"));
			if (0 >= per || per >= 100) {
				flag5 = 1;

			}

		} else if (request.getParameter("postgraduationmarks") == null
				&& request.getParameter("postgraduationpercentage").isEmpty()) {

		} else {
			flag5 = 1;
		}
		if (request.getParameter("gatescore") != null && !request.getParameter("gatepercentage").isEmpty()) {
			Double per = Double.parseDouble(request.getParameter("gatepercentage"));
			if (per >= 1000) {
				flag6 = 1;

			}

		} else if (request.getParameter("gatescore") == null && request.getParameter("gatepercentage").isEmpty()) {

		} else {
			flag6 = 1;
		}

	}

	private void filterResult(HttpServletRequest request, HttpServletResponse response)
			throws FileNotFoundException, IOException {
		boolean flagEmail = false;
		boolean flagName = false;
		boolean flagEnrollmentNumber = false;
		boolean flagCategory = false;
		boolean flagGender = false;
		boolean flagPhysicallyDisabled = false;
		boolean flagDOB = false;
		boolean flagPhdstream = false;
		boolean flagGraduationDegree = false;
		boolean flagPostGraduationDegree = false;
		boolean flagXBoard = false;
		boolean flagXIIBoard = false;
		boolean flagGraduationDepartment = false;
		boolean flagPostGraduationDepartment = false;
		boolean flagGraduationUniversity = false;
		boolean flagPostGraduationUniversity = false;
		boolean flagGraduationState = false;
		boolean flagPostGraduationState = false;
		boolean flagXpercentage = false;
		boolean flagXIIpercentage = false;
		boolean flagGraduationPercentage = false;
		@SuppressWarnings("unused")
		boolean flagPostGraduationPercentage = false;
		boolean flagGATEScore = false;
		@SuppressWarnings("unused")
		boolean flagtime1 = false;
		@SuppressWarnings("unused")
		boolean flagtime2 = false;
		if (!request.getParameter("email").isEmpty()) {
			flagEmail = true;
		}
		if (!request.getParameter("name").isEmpty()) {
			flagName = true;
		}
		if (!request.getParameter("eno").isEmpty()) {
			flagEnrollmentNumber = true;
		}
		if (!request.getParameter("category").equalsIgnoreCase("All")) {
			flagCategory = true;
		}
		if (request.getParameter("gender") != null) {
			flagGender = true;
		}
		if (request.getParameter("pd") != null) {
			flagPhysicallyDisabled = true;
		}
		if (request.getParameter("dobradiobutton") != null) {
			flagDOB = true;
		}
		if (!request.getParameter("phdstream").equals("All")) {
			flagPhdstream = true;
		}
		if (!request.getParameter("graduationdegree").equals("All")) {
			flagGraduationDegree = true;
		}
		if (!request.getParameter("postgraduationdegree").equals("All")) {
			flagPostGraduationDegree = true;
		}
		if (!request.getParameter("xboardname").equals("All")) {
			flagXBoard = true;
		}
		if (!request.getParameter("xiiboardname").equals("All")) {
			flagXIIBoard = true;
		}
		if (!request.getParameter("departmentgraduation").equals("All")) {
			flagGraduationDepartment = true;
		}
		if (!request.getParameter("departmentpostgraduation").equals("All")) {
			flagPostGraduationDepartment = true;
		}
		if (!request.getParameter("universitygraduation").isEmpty()) {
			flagGraduationUniversity = true;
		}
		if (!request.getParameter("universitypostgraduation").isEmpty()) {
			flagPostGraduationUniversity = true;
		}
		if (!request.getParameter("stategraduation").equals("All")) {
			flagGraduationState = true;
		}
		if (!request.getParameter("statepostgraduation").equals("All")) {
			flagPostGraduationState = true;
		}
		if (!request.getParameter("xpercentage").isEmpty()) {
			flagXpercentage = true;
		}
		if (!request.getParameter("xiipercentage").isEmpty()) {
			flagXIIpercentage = true;
		}
		if (!request.getParameter("graduationpercentage").isEmpty()) {
			flagGraduationPercentage = true;
		}
		if (!request.getParameter("postgraduationpercentage").isEmpty()) {
			flagPostGraduationPercentage = true;
		}
		if (!request.getParameter("gatepercentage").isEmpty()) {
			flagGATEScore = true;
		}
		if (!request.getParameter("dobfrom").isEmpty()) {
			flagtime1 = true;
		}
		if (!request.getParameter("dobupto").isEmpty()) {
			flagtime2 = true;
		}

		String savePath = System.getProperty("user.home") + File.separator + SAVE_DIR + File.separator + "Final";
		BufferedReader CSVReader = new BufferedReader(new FileReader(savePath + File.separator + "database.txt"));
		String tmp;

		// System.out.println(CSVReader.readLine());
		while ((tmp = CSVReader.readLine()) != null) {
			String[] entry = tmp.split(";");
			int x = 0;
			while (x < 60) {
				System.out.println(entry[x] + "  " + x);
				x++;
			}

			String fileEmail;
			String fileName;
			String fileStream;
			String fileGender;
			String fileCategory;
			String filePD;
			String[] dobParts;
			String filexBoard;
			String filexPercentage;
			String filexiiBoard;
			String filexiiPercentage;
			String fileGraduationDegree;
			String fileGraduationDiscipline;
			String fileGraduationUniversity;
			String fileGraduationPercentage;
			String filePgState;
			String filePgDegree;
			@SuppressWarnings("unused")
			String filePgPercentage;
			String filePgCollege;
			String enrollmentno;

			/*
			 * enrollment number entry[0] email entry[1] name entry[2] address
			 * part1 entry[3] address part2 entry[4] address part3 entry[5]
			 * phonenumber entry[6] phd stream entry[7] PhD Area Preference 1
			 * entry[8] PhD Area Preference 2 entry[9] PhD Area Preference 3
			 * entry[10] Gender entry[11] Category entry[12] Physically Disabled
			 * entry[13] DOB entry[14] Children/War Widows of Defence Personnel
			 * killed/Disabled in Action entry[15] Father's Name entry[16]
			 * Nationality entry[17] Permanent Address 1 entry[18] Permanent
			 * Address 2 entry[19] Permanent Address 1 entry[20] Pin Code
			 * entry[21] Xth Board entry[22] Xth Marks (%) entry[23] Year of
			 * Passing Xth entry[24] XIIth Board entry[25] XIIth Marks (%)
			 * entry[26] Year of Passing XIIth entry[27] Graduation Degree
			 * entry[28] Graduation Department entry[29] Graduation College
			 * entry[30] Graduation University entry[31] Graduation City
			 * entry[32] Graduation State entry[33] Year of Graduation entry[34]
			 * Grad CGPA or Marks entry[35] PhD ECE PhD Subject Preference 1
			 * entry[36] ECE PhD Subject Preference 2 entry[37] ECE PhD Subject
			 * Preference 3 entry[38] ECE PhD Subject Preference 4 entry[39]
			 * Post Grad College entry[40] Post Grad City entry[41] Post Grad
			 * State entry[42] Post Grad Department entry[43] Post Grad Degree
			 * entry[44] Post Grad Thesis entry[45]
			 * 
			 * 
			 * Year of Post Grad entry[46] Post Grad CGPA or Marks entry[47]
			 * 
			 * Exam Name entry[48] Subject entry[49] Year entry[50] Score
			 * entry[51] Rank entry[52]
			 * 
			 * GATE Area entry[53] Year of Graduation entry[54] Marks(%)
			 * entry[55] Score entry[56] Rank entry[57] Achievements entry[58]
			 * Timestamp entry[59]
			 * 
			 * 
			 */

			fileEmail = entry[1];// email read
			fileName = entry[2]; // name read
			fileStream = entry[7];// read PhDStream
			fileGender = entry[11]; // gender read
			fileCategory = entry[12]; // category read
			filePD = entry[13]; // pd read
			dobParts = entry[14].split("/"); // dob read
			filexBoard = entry[22]; // read xboard
			filexPercentage = entry[23];
			filexiiBoard = entry[25]; // read 12 board
			filexiiPercentage = entry[26]; // read percanetage
			fileGraduationDegree = entry[28]; // read graduation degree
			fileGraduationDiscipline = entry[29]; // read graduation discipline
			fileGraduationUniversity = entry[31]; // read graduation University
			String fileGraduationState = entry[33]; // graduation state
			fileGraduationPercentage = entry[35]; // read percentage
			filePgCollege = entry[40]; // not skip pg college
			filePgState = entry[42]; // read pg state
			@SuppressWarnings("unused")
			String filePgDiscipline = entry[43]; // pg discipline
			filePgDegree = entry[44]; // pg degree
			filePgPercentage = entry[47]; // pg percentage
			String fileGatescore = entry[56]; // read gate score
			enrollmentno = entry[0];

			if (flagEmail) {
				if (request.getParameter("email").equalsIgnoreCase(fileEmail)) {
				} else {
					continue;
				}
			}
			if (flagName) {
				if (request.getParameter("name").equalsIgnoreCase(fileName.toLowerCase())) {
				} else {
					continue;
				}
			}
			if (flagEnrollmentNumber) {
				System.err.println("roll check");
				if (request.getParameter("eno").toLowerCase().equals(enrollmentno.toLowerCase())) {
				} else {
					continue;
				}
			}
			if (flagGraduationUniversity) {
				System.err.println("graduation uni check");
				if (request.getParameter("universitygraduation").toLowerCase()
						.equals(fileGraduationUniversity.toLowerCase())) {
				} else {
					continue;
				}
			}
			if (flagPostGraduationUniversity) {
				System.err.println("pg uni check");
				if (request.getParameter("universitypostgraduation").toLowerCase()
						.equals(filePgCollege.toLowerCase())) {
				} else {
					continue;
				}
			}
			if (flagGender) {
				System.err.println("gender check");
				if (request.getParameter("gender").equals("male") && fileGender.toLowerCase().equals("male")) {
				} else if (request.getParameter("gender").equals("female")
						&& fileGender.toLowerCase().equals("female")) {
				} else {
					continue;
				}
			}
			if (flagDOB) {
				System.err.println("dob check");

				@SuppressWarnings("unused")
				String[] date = request.getParameter("dobdatepicker").split("-"); // 2009-12-13
				System.err.println(dobParts[0] + " " + dobParts[1] + " " + dobParts[2] + " ");
				int month = Integer.parseInt(dobParts[0]);
				int day = Integer.parseInt(dobParts[1]);
				int year = Integer.parseInt(dobParts[2]);
				String[] readdate = request.getParameter("dobdatepicker").split("/");
				int readmonth = Integer.parseInt(readdate[1]);
				int readyear = Integer.parseInt(readdate[0]);
				int readday = Integer.parseInt(readdate[2]);
				if (request.getParameter("dobradiobutton").equals("before") && readyear >= year) {
					if (readyear == year) {
						if (readmonth >= month) {
							if (readmonth == month) {
								if (readmonth >= day) {

								} else {
									continue;
								}
							}
						} else {
							continue;
						}
					}
				} else if (request.getParameter("dobradiobutton").equals("before") && readyear <= year) {
					if (readyear == year) {
						if (readmonth <= month) {
							if (readmonth == month) {
								if (readmonth <= day) {

								} else {
									continue;
								}
							}
						} else {
							continue;
						}
					}
				}

				else if (request.getParameter("dobradiobutton").equals("on") && readday == day && readmonth == month
						&& readyear == year) {
				} else {
					continue;
				}
			}
			if (flagPhysicallyDisabled) {
				System.err.println("pd check");
				if (request.getParameter("pd").equals("pd_yes") && filePD.toLowerCase().equals(("Yes").toLowerCase())) // lasttime
																														// it
																														// was
																														// error
																														// prone
				{
				} else if (request.getParameter("pd").equals("pd_no")
						&& filePD.toLowerCase().equals(("No").toLowerCase())) {
				} else {
					continue;
				}
			}
			if (flagCategory) {
				if (request.getParameter("category").toLowerCase().equals(fileCategory.toLowerCase())) {
				} else {
					continue;
				}
			}
			if (flagXBoard) {
				if (request.getParameter("xboardname").toLowerCase().equals(filexBoard.toLowerCase())) {
				} else {
					continue;
				}
			}
			if (flagXIIBoard) {
				if (request.getParameter("xiiboardname").toLowerCase().equals(filexiiBoard.toLowerCase())) {
				} else {
					continue;
				}
			}
			if (flagGraduationState) {
				if (request.getParameter("stategraduation").toLowerCase().equals(fileGraduationState.toLowerCase())) {
				} else {
					continue;
				}
			}
			if (flagGraduationDegree) {
				if (request.getParameter("graduationdegree").toLowerCase().equals(fileGraduationDegree.toLowerCase())) {
				} else {
					continue;
				}
			}
			if (flagGraduationDepartment) {
				if (request.getParameter("departmentgraduation").toLowerCase()
						.equals(fileGraduationDiscipline.toLowerCase())) {
				} else {
					continue;
				}
			}
			if (flagPostGraduationDegree) {
				if (request.getParameter("postgraduationdegree").toLowerCase().equals(filePgDegree.toLowerCase())) {
				} else {
					continue;
				}
			}
			if (flagPhdstream) {
				if (request.getParameter("phdstream").toLowerCase().equals(fileStream.toLowerCase())) {
				} else {
					continue;
				}
			}
			if (flagPostGraduationDepartment) {
				if (request.getParameter("departmentpostgraduation").toLowerCase()
						.equals(fileGraduationDiscipline.toLowerCase())) {
				} else {
					continue;
				}
			}
			if (flagPostGraduationState) {
				if (request.getParameter("statepostgraduation").toLowerCase().equals(filePgState.toLowerCase())) {
				} else {
					continue;
				}
			}
			if (flagGraduationPercentage) {
				if (fileGraduationPercentage.compareTo("") != 0) {
					System.out.println(enrollmentno);
					if (request.getParameter("graduationmarks").equals("equal")
							&& Double.parseDouble(request.getParameter("graduationpercentage")) == Double
									.parseDouble(fileGraduationPercentage)) {
					} else if (request.getParameter("graduationmarks").equals("lesserthan")
							&& Double.parseDouble(request.getParameter("graduationpercentage")) > Double
									.parseDouble(fileGraduationPercentage)) {
					} else if (request.getParameter("graduationmarks").equals("greaterthan")
							&& Double.parseDouble(request.getParameter("graduationpercentage")) < Double
									.parseDouble(fileGraduationPercentage)) {
					} else {
						continue;
					}
				} else {
					continue;
				}
			}
			if (flagXpercentage) {
				if (filexPercentage.compareTo("") != 0) {
					if (request.getParameter("xboardmarks").equals("equal") && Double
							.parseDouble(request.getParameter("xpercentage")) == Double.parseDouble(filexPercentage)) {
					} else if (request.getParameter("xboardmarks").equals("lesserthan") && Double
							.parseDouble(request.getParameter("xpercentage")) > Double.parseDouble(filexPercentage)) {
					} else if (request.getParameter("xboardmarks").equals("greaterthan") && Double
							.parseDouble(request.getParameter("xpercentage")) < Double.parseDouble(filexPercentage)) {
					} else {
						continue;
					}
				} else {
					continue;
				}
			}
			if (flagXIIpercentage) {
				if (filexiiPercentage.compareTo("") != 0) {
					if (request.getParameter("xiiboardmarks").equals("equal")
							&& Double.parseDouble(request.getParameter("xiipercentage")) == Double
									.parseDouble(filexiiPercentage)) {
					} else if (request.getParameter("xiiboardmarks").equals("lesserthan")
							&& Double.parseDouble(request.getParameter("xiipercentage")) > Double
									.parseDouble(filexiiPercentage)) {
					} else if (request.getParameter("xiiboardmarks").equals("greaterthan")
							&& Double.parseDouble(request.getParameter("xiipercentage")) < Double
									.parseDouble(filexiiPercentage)) {
					} else {
						continue;
					}
				} else {
					continue;
				}
			}
			if (flagGATEScore) {
				if (fileGatescore.compareTo("") != 0) {
					if (request.getParameter("gatescore").equals("equal") && Double
							.parseDouble(request.getParameter("gatepercentage")) == Double.parseDouble(fileGatescore)) {
					} else if (request.getParameter("gatescore").equals("lesserthan") && Double
							.parseDouble(request.getParameter("gatepercentage")) > Double.parseDouble(fileGatescore)) {
					} else if (request.getParameter("gatescore").equals("greaterthan") && Double
							.parseDouble(request.getParameter("gatepercentage")) < Double.parseDouble(fileGatescore)) {
					} else {
						continue;
					}
				} else {
					continue;
				}
			}

			Person p = new Person(fileName, enrollmentno, enrollmentno + ".doc");
			personData.add(p);

		}
		CSVReader.close();

	}
}