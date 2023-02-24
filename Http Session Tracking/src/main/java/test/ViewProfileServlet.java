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
@WebServlet("/view")
public class ViewProfileServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		HttpSession hs = req.getSession(false);//Session
		if(hs==null) {
			pw.println("Session expired...<br>");
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}else {
			UserBean ub = (UserBean)hs.getAttribute("ubean");
			pw.println("page of User : "+ub.getfName()+"<br>");
			RequestDispatcher rd=req.getRequestDispatcher("link.html");
			rd.include(req, res);
			pw.println("<br>"+ub.getfName()+"&nbsp&nbsp"+ub.getlName()
			+"&nbsp&nbsp"+ub.getAddr()+"&nbsp&nbsp"+ub.getmId()+
			"&nbsp&nbsp"+ub.getPhNo());
		}
	}
}
