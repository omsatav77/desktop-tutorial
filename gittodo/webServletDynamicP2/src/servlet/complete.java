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
 * Servlet implementation class complete
 */		
@WebServlet("/complete")
public class complete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		PrintWriter out=response.getWriter();
   	String emr[]=request.getParameterValues("taskcompleted");
   	int id;
   	for(int i=0;i<emr.length;i++)
   	{
   		id=Integer.parseInt(emr[i]);
   		updatetaskstatus(id);
   	}
	response.sendRedirect("todoadd");
   	
   	
   	}

   	public static void updatetaskstatus(int uid) {

		try {
		   Connection con= Connect.GetConn();
					
//				Statement statement=con.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
			Statement statement=con.createStatement();
		   ResultSet rss= statement.executeQuery("select * from todoadd");
				
		   rss.beforeFirst();
				
				while (rss.next()) 
				{

					if(uid==rss.getInt(5)&& rss.getString(1).equals(todoservlet.finEmail) )
					{
					String quesry="	update todoadd set status1='completed' where id="+uid;
					statement.executeUpdate(quesry);
					break;
					}
				}
				rss.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}	


}
