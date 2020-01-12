import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Scanner;
@MultipartConfig
public class AddQ1 extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();       
        String  q1=request.getParameter("q1");
        String  q2=request.getParameter("q2");
        String  q3=request.getParameter("q3");
        String  q4=request.getParameter("q4");
        String  q5=request.getParameter("q5");
        String  q6=request.getParameter("q6");
        String  q7=request.getParameter("q7");
        String  q8=request.getParameter("q8");
        String  q9=request.getParameter("q9");
        String  q10=request.getParameter("q10");
        String  a1=request.getParameter("a1");
        String  a2=request.getParameter("a2");
        String  a3=request.getParameter("a3");
        String  a4=request.getParameter("a4");
        String  a5=request.getParameter("a5");
        String  a6=request.getParameter("a6");
        String  a7=request.getParameter("a7");
        String  a8=request.getParameter("a8");
        String  a9=request.getParameter("a9");
        String  a10=request.getParameter("a10");
        System.out.println(q1);
        System.out.println(q2);
        try{
        	
        Class.forName("oracle.jdbc.driver.OracleDriver");
          Connection  con=DriverManager.getConnection
                     ("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
          request.getRequestDispatcher("nav3.html").include(request, response);

        PreparedStatement ps1=con.prepareStatement
                  ("insert into quiz(questions,answers) values(?,?)");
        ps1.setString(1, q1);
        ps1.setString(2, a1);
        PreparedStatement ps2=con.prepareStatement
                ("insert into quiz(questions,answers) values(?,?)");
        ps2.setString(1, q2);
        ps2.setString(2, a2);
        PreparedStatement ps3=con.prepareStatement
                ("insert into quiz(questions,answers) values(?,?)");
        ps3.setString(1, q3);
        ps3.setString(2, a3);
        PreparedStatement ps4=con.prepareStatement
                ("insert into quiz(questions,answers) values(?,?)");
        ps4.setString(1, q4);
        ps4.setString(2, a4);
        PreparedStatement ps5=con.prepareStatement
                ("insert into quiz(questions,answers) values(?,?)");
        ps5.setString(1, q5);
        ps5.setString(2, a5);
        PreparedStatement ps6=con.prepareStatement
                ("insert into quiz(questions,answers) values(?,?)");
        ps6.setString(1, q6);
        ps6.setString(2, a6);
        PreparedStatement ps7=con.prepareStatement
                ("insert into quiz(questions,answers) values(?,?)");
        ps7.setString(1, q7);
        ps7.setString(2, a7);
        PreparedStatement ps8=con.prepareStatement
                ("insert into quiz(questions,answers) values(?,?)");
        ps8.setString(1, q8);
        ps8.setString(2, a8);
        PreparedStatement ps9=con.prepareStatement
                ("insert into quiz(questions,answers) values(?,?)");
        ps9.setString(1, q9);
        ps9.setString(2, a9);
        PreparedStatement ps10=con.prepareStatement
                ("insert into quiz(questions,answers) values(?,?)");
        ps10.setString(1, q10);
        ps10.setString(2, a10);
        ps1.executeUpdate();
        ps2.executeUpdate();
        ps3.executeUpdate();
        ps4.executeUpdate();
        ps5.executeUpdate();
        ps6.executeUpdate();
        ps7.executeUpdate();
        ps8.executeUpdate();
        ps9.executeUpdate();
        ps10.executeUpdate();
        

            out.println("<br><br><br><br>Success : Inserted");
    
        }
        catch(Exception se)
        {
            se.printStackTrace();
        }
	
      }
  }
