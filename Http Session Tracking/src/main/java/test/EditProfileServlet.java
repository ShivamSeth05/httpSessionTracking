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
@WebServlet("/edit")
public class EditProfileServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			pw.println("Session expired...<br>");
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}else {
			UserBean ub = (UserBean)hs.getAttribute("ubean");
			pw.println("<form action='update' method='post'>");
			pw.println("Address:<input type='text' name='addr'value='"+ub.getAddr()+"'><br>");

			pw.println("MailId:<input type='text' name='mid' value='"+ub.getmId()+"'><br>");

			pw.println("PhoneNo:<input type='text' name='phno'value='"+ub.getPhNo()+"'><br>");

			pw.println("<input type='submit' value='UpdateProfile'>");
			pw.println("</form>");
		}
	}
}
