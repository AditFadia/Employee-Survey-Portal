import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/adminsave")
public class adminsave  extends HttpServlet {
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
     {
           doPost(request, response);
     }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String username=request.getParameter("username");
		String password=request.getParameter("pasword");
	
		
		Emp e=new Emp();
		//e.setId((int)(Math.random() * 11 + 10));
		e.setName(username);
		e.setPassword(password);
	
		
		int status=admindao.save(e);
		if(status>0){
			out.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("Login.html").include(request, response);
		}else{
			out.println("Sorry! unable to save record");
		}
		
		out.close();
	}

}



