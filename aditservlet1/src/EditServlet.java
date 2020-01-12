


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session != null) {
			Boolean isLogin = (Boolean) session.getAttribute("isLogin");
			if (isLogin) {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("nav.html").include(request, response);

		out.print("<br><br><br>");
		out.println("<h1>Update Employee</h1>");
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		
		Emp e=EmpDao.getEmployeeById(id);

		out.print("<form action='EditServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");
		out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");
		out.print("<tr><td>Password:</td><td><input type='password' name='password' value='"+e.getPassword()+"'/></td></tr>");
		out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+e.getEmail()+"'/></td></tr>");
		out.print("<tr><td>Country:</td><td>");
		out.print("<select name='country' style='width:150px'>");
		out.print("<option>India</option>");
		out.print("<option>USA</option>");
		out.print("<option>UK</option>");
		out.print("<option>Other</option>");
		out.print("</select>");
		out.print("</td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		
		out.close();
	}
			else {
				// out.print("Please login first");
				request.getRequestDispatcher("Login.html").include(request, response);
			}

		} else {
			// out.print("Please login first");
			request.getRequestDispatcher("Login.html").include(request, response);
		}
	}
}
