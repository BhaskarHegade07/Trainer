package com.TrainerApp.Servlets;

import java.io.IOException;

import com.TrainerApp.DAO.StudentDao;
import com.TrainerApp.DTO.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet{
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	 //collecting data from the front end
	 String id=req.getParameter("id");
	String pass=req.getParameter("password");
	//conversion of type of data
	int sid=0;
	try {
	 sid=Integer.parseInt(id);
	}
	catch(NumberFormatException e) {
		System.out.println(e.getMessage());
	}
	//calling printwriter for response 
	
//	PrintWriter out=resp.getWriter();

	//jdbc implementation
	Student s=new Student();
	StudentDao sdao=new StudentDao();
	
	s=sdao.getStudent(sid, pass);
	if(s!=null) {
//		out.println("<h1>Login Successful Hii "+s.getName()+"</h1>"
//				+"<a href=\"login.html\">Back</a>");
		
		req.setAttribute("student", s);
		RequestDispatcher rd=req.getRequestDispatcher("Home.jsp");
		rd.forward(req, resp);
	}
	else {
//		out.println("<h1>Failed to login</h1>");
		req.setAttribute("error","Invalid student id or password!!");
		RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
		rd.forward(req, resp);
	}
	
}
}
