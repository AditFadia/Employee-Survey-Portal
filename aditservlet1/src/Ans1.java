import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
@MultipartConfig
public class Ans1 extends HttpServlet {
    
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
    
ArrayList<String> list = new ArrayList<String>(); 


String  q0=request.getParameter("q0");
String  q1=request.getParameter("q1");
String  q2=request.getParameter("q2");
String  q3=request.getParameter("q3");
String  q4=request.getParameter("q4");
String  q5=request.getParameter("q5");
String  q6=request.getParameter("q6");
String  q7=request.getParameter("q7");
String  q8=request.getParameter("q8");
String  q9=request.getParameter("q9");
String ans0=request.getParameter("ans0");
String ans1=request.getParameter("ans1");
String ans2=request.getParameter("ans2");
String ans3=request.getParameter("ans3");
String ans4=request.getParameter("ans4");
String ans5=request.getParameter("ans5");
String ans6=request.getParameter("ans6");
String ans7=request.getParameter("ans7");
String ans8=request.getParameter("ans8");
String ans9=request.getParameter("ans9");

System.out.println(q0);
System.out.println(q1);
System.out.println(ans0);




try{


Class.forName("oracle.jdbc.driver.OracleDriver");


  Connection  con=DriverManager.getConnection
             ("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
  
  request.getRequestDispatcher("nav3.html").include(request, response);

PreparedStatement ps=con.prepareStatement
          ("select answers from quiz where questions='"+q0+"' or questions='"+q1+"' or questions='"+q2+"' or questions='"+q3+"' or questions='"+q4+"' or questions='"+q5+"' or questions='"+q6+"' or questions='"+q7+"' or questions='"+q8+"' or questions='"+q9+"'");
int j=0;

ResultSet rs=ps.executeQuery();  
while(rs.next())  
{
	list.add(rs.getString("answers"));
	
}

System.out.println(list.get(0));
	if(list.get(0).equals(ans0))
	{
		j=j+1;
	}
	if(list.get(1).equals(ans1))
	{
		j=j+1;
	}
	if(list.get(2).equals(ans2))
	{
		j=j+1;
	}
	if(list.get(3).equals(ans3))
	{
		j=j+1;
	}
	if(list.get(4).equals(ans4))
	{
		j=j+1;
	}
	if(list.get(5).equals(ans5))
	{
		j=j+1;
	}
	if(list.get(6).equals(ans6))
	{
		j=j+1;
	}
	if(list.get(7).equals(ans7))
	{
		j=j+1;
	}
	if(list.get(8).equals(ans8))
	{
		j=j+1;
	}
	if(list.get(9).equals(ans9))
	{
		j=j+1;
	}



out.println("<center><br><br><br><br><h1>Your Match Result is :"+j+" / 10</h1></center>");

}catch (Exception e2) {e2.printStackTrace();}  

finally{out.close();}  

	}
} 