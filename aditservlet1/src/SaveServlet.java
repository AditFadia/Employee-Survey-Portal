
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		if (session != null) {
			Boolean isLogin = (Boolean) session.getAttribute("isLogin");
			if (isLogin) {

				response.setContentType("text/html");
				PrintWriter out = response.getWriter();

				String name = request.getParameter("name");
				String password = request.getParameter("password");
				String email = request.getParameter("email");
				String country = request.getParameter("country");

				Emp e = new Emp();
				e.setId(getUniqueNumber(1,5000));
				e.setName(name);
				e.setPassword(password);
				e.setEmail(email);
				e.setCountry(country);

				int status = EmpDao.save(e);
				if (status > 0) {
					out.print("<p>Record saved successfully!</p>");
					request.getRequestDispatcher("index.html").include(request, response);
				} else {
					out.println("Sorry! unable to save record");
				}

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

	private int getUniqueNumber(int lowerbound, int upperbound) {
		return (int)(Math.random() * ((upperbound - lowerbound) + 1) + lowerbound);
	}

}
