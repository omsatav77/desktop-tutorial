package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Todotask;

@WebServlet("/todoview")
public class todoview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

   		response.setContentType("text/html:");
   		PrintWriter out=response.getWriter();
   		out.println("<!DOCTYPE html>");
 		out.println("<html>");
 		out.println("<head>");
 		out.println("<title>todolist List</title>");
 		out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\">");
 		out.println("</head>");
 		out.println("<body>");
	
 		out.println("<div class='container'>");
 		out.print("<h1 style=\"text-align: center;\">To-Do List</h1>");
 		out.println("<form action='complete' method='get'>");
 		out.println("<table class='table table-bordered table-striped'>");
 		out.print("<tr><th></th><th>User id </th><th>Title</th><th>Desccription</th><th>Status</th><th>Edit</th><th>Delete</th>");
 		
 		todoadd.tasklist();
 		for(Todotask bean:Todotask.todolist){
 			
 			out.print("<tr><td><input type='checkbox' name='taskcompleted' value='"+bean.getId()+"' /></td><td>"+bean.getTitle1()+" "+bean.getDesc1()+"</td><td>"+bean.getStatus1()+"</td><td ><a href='Edittodotask?id="+bean.getId()+"'>Edit</a></td><td><a href='deletetodotask?id="+bean.getId()+"'>Delete</a></td></tr>");
 			 
 			
 		}
 		out.println("</table>");
 		
 		out.println("<br>");
 		out.println("<button type='submit' class=\"btn btn-success\">Complete Task</button>");
 		out.println("<a href=\"todoAdd.html\"><input type=\"button\" class=\"btn btn-primary btn-lg btn-block\" name=\"button \"value=\"Add new Todo\">");
 		out.println("</form>");
 		out.println("</div>");
 		out.println("</body>");
 		out.println("</html>");
 		
 		out.close();

   		
	}

}
