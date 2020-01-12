

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SerExam2 extends HttpServlet 
{
      Connection con;
      PreparedStatement ps;
      ResultSet rs;
      public void init(ServletConfig config)throws ServletException
      { 
            try 
               {
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234"); 
               } 
                  catch (ClassNotFoundException e)
                     {
                        System.out.println(e);
                     } 
                  catch (SQLException e) 
                     {
                        System.out.println(e);
                     }
      }
      protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
      {
            doPost(request, response);
      }
      protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
      {
            response.setContentType("text/html");
            PrintWriter pw=response.getWriter();
     /*       String emailid=request.getParameter("emailid");
            String pasword=request.getParameter("pasword");*/
            String email=request.getParameter("email");
            String password=request.getParameter("password");
            pw.println("<html><body>");
            try 
            {
                /*  ps=con.prepareStatement("select * from quizlogin where emailid= ? and pasword= ?");
                  ps.setString(1, emailid);
                  ps.setString(2, pasword);
                  rs=ps.executeQuery();*/
            	request.getRequestDispatcher("nav1.html").include(request, response);
            
            	 ps=con.prepareStatement("select * from user905 where email= ? and password= ?");
                 ps.setString(1, email);
                 ps.setString(2, password);
                 rs=ps.executeQuery();
                  if(rs.next())
                  {
                   //     pw.println("<center><h3>welcome " +" " + emailid +"</h3></center>");
                	  pw.println("<br><br><br><br>");
                	    pw.println("<center><h3>welcome " +" " + email +"</h3></center>");
                        RequestDispatcher rd1=request.getRequestDispatcher("./index2.html");
                      //  request.getRequestDispatcher("home.html").include(request, response);
                        rd1.include(request,response);
                        //or
                        //response.sendRedirect("./home.html");
                        
                        System.out.println(rs.next());
                        
                        
                        pw.println("<form method=\"post\" action=\"Login.html\">");
        //                pw.println("<input type=\"submit\" name=\"logout\" " + "value=\"Logout\">");
                        pw.println("</form>");
                        
                  }
                  else
                  {
                        pw.println("<center><h3>invalid username/password Enter Correct emailid/password</h3></center>");
                       RequestDispatcher rd2=request.getRequestDispatcher("./Login.html");
                       rd2.include(request,response);
                       
                  }
            }
            catch (SQLException e) 
                  {
                  e.printStackTrace();
                  }
      }
} 
