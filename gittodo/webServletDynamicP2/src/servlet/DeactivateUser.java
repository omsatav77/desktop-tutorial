package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.SpinnerListModel;

/**
 * Servlet implementation class Deleteuser
 */
@WebServlet("/DeactivateUser")
public class DeactivateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
      static String uid;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("running Deleteuser");
		PrintWriter out=response.getWriter();
		uid=request.getParameter("id");
//		System.out.println(uid);
		DeleteEmp();
//		request.getRequestDispatcher("adminpage").forward(request, response);
		response.sendRedirect("adminpage");
	}
public static void DeleteEmp() {

	try {
	   Connection con= Connect.GetConn();
				
			Statement statement=con.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs= statement.executeQuery("select * from registration");
			while (rs.next()) {

				if(uid.equals(rs.getString("email1")))
				{
					if(rs.getString("status").equals("activated"))
					{
					rs.updateString(8, "deactivated");	
					
					}
					else {
						rs.updateString(8, "activated");
					}
					rs.updateRow();
				}
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}	

}
