package allserv;
import java.sql.*;
import database.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserLog
 */
@WebServlet("/UserLog")
public class UserLog extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out=response.getWriter();
			Connection cn=UserConnect.getCn();
			String id=request.getParameter("id");
			String pass=request.getParameter("pass");
			PreparedStatement ps=cn.prepareStatement("select cid,cpass from member where cid=? and cpass=?");
			ps.setString(1, id);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				HttpSession ses=request.getSession();
				ses.setAttribute("uid", id);
				RequestDispatcher rd=request.getRequestDispatcher("personal.html");
				rd.forward(request, response);
				
			}else {
				out.print("no record found");
				RequestDispatcher rd=request.getRequestDispatcher("login.html");
				rd.include(request, response);
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
