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
 * Servlet implementation class AddData
 */
@WebServlet("/AddData")
public class AddData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out=response.getWriter();
			Connection cn=UserConnect.getCn();
			HttpSession ses=request.getSession(false);
			String cid=(String)ses.getAttribute("uid");
			String cname=request.getParameter("cname");
			String cadr=request.getParameter("cadr");
			String cphn=request.getParameter("cphn");
			String cmail=request.getParameter("cmail");
			PreparedStatement ps=cn.prepareStatement("insert into contact values(?,?,?,?,?)");
			ps.setString(1, cid);
			ps.setString(2, cname);
			ps.setString(3, cadr);
			ps.setString(4, cphn);
			ps.setString(5, cmail);
			ps.execute();
			out.print("Successfully Added...");
			RequestDispatcher rd=request.getRequestDispatcher("personal.html");
			rd.include(request, response);
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
