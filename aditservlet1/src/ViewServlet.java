
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session != null) {
			Boolean isLogin = (Boolean) session.getAttribute("isLogin");
			if (isLogin) {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				// request.getRequestDispatcher("nav.html").include(request, response);

				out.print("<br><br><br>");
				out.println("<a href='index.html'>Add New Employee</a>");
				out.println("<h1>Employees List</h1>");

				List<Emp> list = EmpDao.getAllEmployees();

				out.print("<table border='1' width='100%'");
				out.print(
						"<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th><th>Edit</th><th>Delete</th></tr>");
				for (Emp e : list) {
					out.print("<tr><td>" + e.getId() + "</td><td>" + e.getName() + "</td><td>" + e.getPassword()
							+ "</td><td>" + e.getEmail() + "</td><td>" + e.getCountry()
							+ "</td><td><a href='EditServlet?id=" + e.getId()
							+ "'>edit</a></td><td><a href='DeleteServlet?id=" + e.getId() + "'>delete</a></td></tr>");
				}
				out.print("</table>");

				out.close();
			} else {
				// out.print("Please login first");
				request.getRequestDispatcher("Login.html").include(request, response);
			}

		} else {
			// out.print("Please login first");
			request.getRequestDispatcher("Login.html").include(request, response);
		}
	}
}
