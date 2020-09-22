package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.empdao;


@WebServlet("/adminpage")
public class adminpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	PrintWriter out=response.getWriter();
    
	static ServletRequest req;
	static ServletResponse res;
	static PrintWriter out;
	
	static int uid;
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
   	{
	
		
   		req=request;
    	res=response;
    	out=res.getWriter();
    	
    	
    	userlist();
    	dispEmp();		
   	
   	}
   	public static void userlist () {
	
	   try {
		   Connection con= Connect.GetConn();
		Statement stm=con.createStatement();
	empdao.userlist= new ArrayList<>();
		
		
					ResultSet rs = stm.executeQuery("select * from registration");
					
					while(rs.next()) {
						
					
						String fname=rs.getString(1);
						String lname=rs.getString(2);
						empdao emp=new empdao();
						emp.setFname(fname);
						emp.setLname(lname);
						emp.setEmail1(rs.getString(3));
						emp.setGendar(rs.getString(4));
						emp.setDateOfBirth(rs.getString(6));
						emp.setPass(rs.getString(5));
						emp.setStatus(rs.getString(8));
			empdao.userlist.add(emp);

					}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
   		
	}
    public static void dispEmp() throws ServletException, IOException
    {
    	
		res.setContentType("text/html");
		out.println("<!DOCTYPE html>");
 		out.println("<html>");
 		out.println("<head>");
 		out.println("<title>View List</title>");
 		out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\">");
 		out.println("</head>");
 		out.println("<body>");
	
 		out.println("<div class='container'>");
 		out.print("<h1 style=\"text-align: center;\">View Userlist</h1>");
 		out.println("<form action='complete' method='post'>");
 		out.println("<table class='table table-bordered table-striped'>");
 		out.print("<tr><th></th><th>Email</th><th>Status</th><th>Activate/Deactivate</th>");
 		
 		
 		for(empdao bean:empdao.userlist){
 			
 			out.print("<tr><td><td>"+bean.getEmail1()+"</td><td>"+bean.getStatus()+"</td><td><a href='DeactivateUser?id="+bean.getEmail1()+"'>Activate/Deactivate</a></td></tr>");
 			
 			
 		}
 		out.println("</table>");
 		
 		out.println("<br>");
// 		out.println("<a id="logout"  href="index.html"><input type="button"  class="btn btn-primary btn-lg btn-block" name="button "value="LOG OUT"></a>");
 out.println("<a id=\"logout\"  href=\"index.html\"><input type=\"button\"  class=\"btn btn-primary btn-lg btn-block\" name=\"button \"value=\"LOG OUT\"></a>");		
 		out.println("</form>");
 		out.println("</div>");
 		out.println("</body>");
 		out.println("</html>");		
 		out.close();
    }
    	
    }


