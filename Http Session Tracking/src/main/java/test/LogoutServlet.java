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
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req,HttpServletResponse res)
			throws ServletException,IOException{
		PrintWriter pw1=res.getWriter();
		res.setContentType("text/html");
		HttpSession hs = req.getSession(false);//Access existing Session
		if(hs==null) {
			pw1.println("<br> Session Expired..");
		}
		else {
			hs.removeAttribute("ubean");
			hs.invalidate();//destroying session
			pw1.println("Logged out Successfully...<br>");
		}
		RequestDispatcher rd = req.getRequestDispatcher("login.html");
		rd.include(req, res);


	}
}
