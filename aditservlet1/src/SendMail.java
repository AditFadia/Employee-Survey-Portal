import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SendMail")
public class SendMail extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session != null) {
			Boolean isLogin = (Boolean) session.getAttribute("isLogin");
			if (isLogin) {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
		String to=request.getParameter("to");
		String subject=request.getParameter("subject");
		String msg=request.getParameter("msg");
		
		Mailer.send(to, subject, msg);
		out.print("message has been sent successfully");
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


