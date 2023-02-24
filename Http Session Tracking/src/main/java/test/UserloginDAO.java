package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

public class UserloginDAO {
	public UserBean ub=null;
	public UserBean login(HttpServletRequest req) {
		try {
			Connection  con=DBConnection.getCon();
			PreparedStatement ps1=con.prepareStatement
					("select * from UserReg50 where uname=? and pword=?");
			ps1.setString(1,req.getParameter("uname"));
			ps1.setString(2,req.getParameter("pword"));
			ResultSet rs = ps1.executeQuery();
			if(rs.next()) {
				ub = new UserBean();
				ub.setuName(rs.getString(1));
				ub.setpWord(rs.getString(2));
				ub.setfName(rs.getString(3));
				ub.setlName(rs.getString(4));
				ub.setAddr(rs.getString(5));
				ub.setmId(rs.getString(6));
				ub.setPhNo(rs.getLong(7));
			}
		}catch(Exception e) {e.printStackTrace();}
		return ub;
	}
}
