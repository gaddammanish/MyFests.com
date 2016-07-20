
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

import java.sql.*;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;


public class registeredUserDb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		 String festname = request.getParameter("festname");
		 String eventheldat = request.getParameter("eventheldat");
        String studentname = request.getParameter("name1");
        String clgname = request.getParameter("clgname");
        String year = request.getParameter("year");
        String branch = request.getParameter("branch");
	String phone=request.getParameter("phone");
	String mailid=request.getParameter("mailid");
	    PrintWriter out = response.getWriter();
       int i=usersRegistartion.eventRegForm(festname,eventheldat,studentname,clgname,year,branch,phone,mailid);
		if(i>0)
		{
			out.println("Registered Successfully");
			  RequestDispatcher rs = request.getRequestDispatcher("start");
               rs.include(request, response);
		}
		else
			out.println("exception  ");
		
    }  
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}
}

 class usersRegistartion
 {

	
     public static int eventRegForm(String festname,String eventheldat,String studentname,String clgname,String year,String branch,String phone,String mailid) 
     {  int rs=0;
      try{
		 
         Class.forName("com.mysql.jdbc.Driver");

 	 //creating connection with the database 
         Connection con=DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/studentinfo","root","manishreddy");
	PreparedStatement statement = con.prepareStatement("INSERT INTO eventRegisters VALUES(?,?,?,?,?,?,?,?,?)");
statement.setString(1,null);

statement.setString(2,festname);
statement.setString(3,eventheldat);

statement.setString(4,studentname);

statement.setString(5,clgname);
statement.setString(6,year);
statement.setString(7,branch);
statement.setString(8,phone);
statement.setString(9,mailid);



    rs=statement.executeUpdate();
 
 
      }catch(Exception e)
      {
          e.printStackTrace();
      }
 return rs;  
            
  }   
	}

