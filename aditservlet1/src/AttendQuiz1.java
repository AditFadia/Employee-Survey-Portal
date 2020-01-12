import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AttendQuiz1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
	
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
ArrayList<String> list = new ArrayList<String>(); 
String name=request.getParameter("name");  
 
          
try{  
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@localhost:1521:xe","system","1234");  
              
request.getRequestDispatcher("nav3.html").include(request, response);
PreparedStatement ps=con.prepareStatement("select * from quiz");

              
out.print("<body>"
		+ "<meta name='viewport' content='width=device-width, initial-scale=1'>"
+ "<link rel='stylesheet' href='https://www.w3schools.com/w3css/4/w3.css'>"
+ "<link rel='stylesheet' href='https://www.w3schools.com/lib/w3-theme-black.css'>"
+ "<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Roboto'>"
+ "<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>"
+ "<link type='text/css' rel='stylesheet' href='${pageContext.request.contextPath}/css/style.css' />"
+ "</body><br><br><br><br><h1>:Questions:</h1>");  
  
ResultSet rs=ps.executeQuery();  
              
  
   
while(rs.next())  
{  

  list.add(rs.getString(1));
                  
}  
  
out.print(
	/*	 "<form method='post' action='answ1' >"
		+ "1. <input type='text' name='q0' size='45'  value='"+list.get(0)+"' /><br/>"
		+ "<input type='radio' name='ans0' value='true'/>True"
		+"<input type='radio' name='ans0' value='false'/>False<br/><br/>"
		+ "2. <input type='text' name='q1' size='45' value='"+list.get(1)+"'/><br/>"
		+ "<input type='radio' name='ans1' value='true'/>True"
		+"<input type='radio' name='ans1' value='false'/>False<br/><br/>"
		+ "3. <input type='text' name='q2' size='45' value='"+list.get(2)+"' /><br/>"
		+ "<input type='radio' name='ans2' value='true'/>True"
		+"<input type='radio' name='ans2' value='false'/>False<br/><br/>"
		+ "4. <input type='text' name='q3' size='45' value='"+list.get(3)+"' /><br/>"
		+ "<input type='radio' name='ans3' value='true'/>True"
		+"<input type='radio' name='ans3' value='false'/>False<br/><br/>"
		+ "5. <input type='text' name='q4' size='45' value='"+list.get(4)+"' /><br/>"
		+ "<input type='radio' name='ans4' value='true'/>True"
		+"<input type='radio' name='ans4' value='false'/>False<br/><br/>"
		+ "6. <input type='text' name='q5' size='45' value='"+list.get(5)+"' /><br/>"
		+ "<input type='radio' name='ans5' value='true'/>True"
		+"<input type='radio' name='ans5' value='false'/>False<br/><br/>"
		+ "7. <input type='text' name='q6' size='45' value='"+list.get(6)+"' /><br/>"
		+ "<input type='radio' name='ans6' value='true'/>True"
		+"<input type='radio' name='ans6' value='false'/>False<br/><br/>"
		+ "8. <input type='text' name='q7' size='45' value='"+list.get(7)+"' /><br/>"
		+ "<input type='radio' name='ans7' value='true'/>True"
		+"<input type='radio' name='ans7' value='false'/>False<br/><br/>"
		+ "9. <input type='text' name='q8' size='45' value='"+list.get(8)+"' /><br/>"
		+ "<input type='radio' name='ans8' value='true'/>True"
		+"<input type='radio' name='ans8' value='false'/>False<br/><br/>"
		+ "10. <input type='text' name='q9' size='45' value='"+list.get(9)+"' /><br/>"
		+ "<input type='radio' name='ans9' value='true'/>True"
		+"<input type='radio' name='ans9' value='false'/>False<br/><br/>"
		+ "<input type='submit' value='Result'/></form></center>");*/
		
		
		"<form method='post' action='answ1' >"
		+ "1. <input type='text' name='q0' size='45'  value='"+list.get(0)+"' /><br/>"
		+ "<input type='radio' name='ans0' value='yes'/>Yes"
		+"<input type='radio' name='ans0' value='no'/>No<br/><br/>"
		+ "2. <input type='text' name='q1' size='45' value='"+list.get(1)+"'/><br/>"
		+ "<input type='radio' name='ans1' value='yes'/>Yes"
		+"<input type='radio' name='ans1' value='no'/>No<br/><br/>"
		+ "3. <input type='text' name='q2' size='45' value='"+list.get(2)+"' /><br/>"
		+ "<input type='radio' name='ans2' value='yes'/>Yes"
		+"<input type='radio' name='ans2' value='no'/>No<br/><br/>"
		+ "4. <input type='text' name='q3' size='45' value='"+list.get(3)+"' /><br/>"
		+ "<input type='radio' name='ans3' value='yes'/>Yes"
		+"<input type='radio' name='ans3' value='no'/>No<br/><br/>"
		+ "5. <input type='text' name='q4' size='45' value='"+list.get(4)+"' /><br/>"
		+ "<input type='radio' name='ans4' value='yes'/>Yes"
		+"<input type='radio' name='ans4' value='no'/>No<br/><br/>"
		+ "6. <input type='text' name='q5' size='45' value='"+list.get(5)+"' /><br/>"
		+ "<input type='radio' name='ans5' value='yes'/>Yes"
		+"<input type='radio' name='ans5' value='no'/>No<br/><br/>"
		+ "7. <input type='text' name='q6' size='45' value='"+list.get(6)+"' /><br/>"
		+ "<input type='radio' name='ans6' value='yes'/>Yes"
		+"<input type='radio' name='ans6' value='no'/>No<br/><br/>"
		+ "8. <input type='text' name='q7' size='45' value='"+list.get(7)+"' /><br/>"
		+ "<input type='radio' name='ans7' value='yes'/>Yes"
		+"<input type='radio' name='ans7' value='no'/>No<br/><br/>"
		+ "9. <input type='text' name='q8' size='45' value='"+list.get(8)+"' /><br/>"
		+ "<input type='radio' name='ans8' value='yes'/>Yes"
		+"<input type='radio' name='ans8' value='no'/>No<br/><br/>"
		+ "10. <input type='text' name='q9' size='45' value='"+list.get(9)+"' /><br/>"
		+ "<input type='radio' name='ans9' value='yes'/>Yes"
		+"<input type='radio' name='ans9' value='no'/>No<br/><br/>"
		+ "<input type='submit' value='Result'/></form></center>");
		
              
}catch (Exception e2) {e2.printStackTrace();}  
          
finally{out.close();}  


		}
}
