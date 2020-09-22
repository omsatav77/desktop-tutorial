package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class updatetask
 */
@WebServlet("/updatetask")
public class updatetask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       static int uid1;
	public static void getuid(int uidd)
	{
		uid1=uidd;
	}
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		PrintWriter out=response.getWriter();
    		try {
    			   Connection con= Connect.GetConn();
    						
    					Statement statement=con.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
    					ResultSet rs= statement.executeQuery("select * from todoadd");
    					while (rs.next()) {

    						if(uid1==rs.getInt(5))
    						{

    							rs.updateString(2,request.getParameter("tname"));
    							rs.updateString(3,request.getParameter("desc"));
    							rs.updateRow();
    							break;
    						}
    					}
    					rs.close();
    					} catch (SQLException e) {
    						// TODO Auto-generated catch block
    						e.printStackTrace();
    					}
    		
    		response.sendRedirect("todoadd");;
    		
    	
    	}
    	
    	

}
