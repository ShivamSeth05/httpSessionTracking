
package test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/log")
public class UserLoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		UserBean ub = new UserloginDAO().login(req);
		if(ub==null) {
			pw.println("Invalid Login Process...<br>");
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.include(req, resp);
		}else {
			HttpSession hs = req.getSession();//New Session created
			hs.setAttribute("ubean", ub);//UserBean added to Session
			pw.println("Welcome User : "+ub.getfName()+"<br>");
			RequestDispatcher rd = req.getRequestDispatcher("link.html");
			rd.include(req, resp);
		}
	}
}
