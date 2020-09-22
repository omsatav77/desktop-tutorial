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
import javax.swing.plaf.synth.SynthStyle;

import org.apache.catalina.storeconfig.WatchedResourceSF;
import org.eclipse.jdt.internal.compiler.ast.WhileStatement;

/**
 * Servlet implementation class deletetodotask
 */
@WebServlet("/deletetodotask")
public class deletetodotask extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 static int uid;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		uid=Integer.parseInt(request.getParameter("id"));
		System.out.println(uid);
		Deletetodo();
	response.sendRedirect("todoadd");	
	}
		 
	
	public static void Deletetodo() {

		try {
		   Connection con= Connect.GetConn();
					
//				Statement statement=con.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
			Statement statement=con.createStatement();
		   ResultSet rss= statement.executeQuery("select * from todoadd");
				
		   rss.beforeFirst();
				
				while (rss.next()) 
				{

					if(uid==rss.getInt(5))
					{
					String quesry="	delete from todoadd where id="+uid;
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
