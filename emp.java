package miniproject;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
* Servlet implementation class emp
* 
*/
@WebServlet("/emp")
public class emp extends HttpServlet
{
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
PrintWriter pw=response.getWriter();
String b=request.getParameter("empname");
String c=request.getParameter("empno");
String d=request.getParameter("age");
String e=request.getParameter("salary");
String f=request.getParameter("city");
System.out.println("done");
try {
System.out.println("enters ");
Class.forName ("org.h2.Driver");
System.out.println("driver is done");
Connection con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","sa");
String str = "insert into DETAIL1 values(?,?,?,?,?)";
System.out.println("connection done"); // Step 2:Create a statement using connection object
PreparedStatement ps=con.prepareStatement(str);
ps.setString(1, b);
ps.setString(2, c);
ps.setString(3, d);
ps.setString(4, e);
ps.setString(5, f);
ps.execute();

System.out.println(" after submission");
response.sendRedirect("submitform.jsp");
con.close();
}
catch (Exception e2){
System.out.println("error");
System.out.println(e2);
}
}
}
