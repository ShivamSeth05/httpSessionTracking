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
@WebServlet("/update")
public class UpdateProfileServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)

			throws ServletException,IOException{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			pw.println("Session expired...&lt;br&gt;");
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}else {
			UserBean ub = (UserBean)hs.getAttribute("ubean");
			ub.setAddr(req.getParameter("addr"));
			ub.setmId(req.getParameter("mid"));
			ub.setPhNo(Long.parseLong(req.getParameter("phno")));
			pw.println("Page of User : "+ub.getfName()+"&lt;br&gt;");
			RequestDispatcher rd = req.getRequestDispatcher("link.html");
			rd.include(req, res);
			int k = new UpdateProfileDAO().update(ub);
			if(k>0) {
				pw.println("<br>Profile updated Successfully...");
			}

		}
	}
}
