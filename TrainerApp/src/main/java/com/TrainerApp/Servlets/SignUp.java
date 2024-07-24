package com.TrainerApp.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.TrainerApp.DAO.StudentDao;
import com.TrainerApp.DTO.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class SignUp extends  HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//collecting the request from the client
	String name=req.getParameter("Name");
	String phoneNumber=req.getParameter("Phone");
	String mail=req.getParameter("Mail");
	String branch=req.getParameter("Branch");
	String location=req.getParameter("Location");
	String password=req.getParameter("Password");
	String confirmPassword=req.getParameter("ConfirmPassword");
	
	//Conversion of data
	long phone=Long.parseLong(phoneNumber);
	
	//calling PrintWriter
	PrintWriter out=resp.getWriter();
	
	
	//JDBC logic
	//DAO logic
	Student s=new Student();
	StudentDao sdao=new StudentDao();
	s.setName(name);
	s.setPhone(phone);
	s.setMail(mail);
	s.setBranch(branch);
	s.setLocation(location);
	if(password.equals(confirmPassword)) {
		s.setPassword(password);
		boolean res=sdao.insertStudent(s);
		if(res) {
			s=sdao.getStudent(phone);
			if(s!=null) {
				//out.println("<h1>Data added successfully! Your Student Id is "+s.getSid()+"</h1>");
				//req.setAttribute("student", s);
				req.setAttribute("signupSuccess","Successfully created the account!! Your student id "+s.getSid());
				RequestDispatcher rd=req.getRequestDispatcher("SignUp.jsp");
				rd.forward(req, resp);
			}
		}
			else {
				//out.println("<h1>Failed to save data </h1>");
				req.setAttribute("error1","Failed to save data!!");
				RequestDispatcher rd=req.getRequestDispatcher("SignUp.jsp");
				rd.forward(req, resp);
			}
			
		}
		else {
			//out.println("Password mismatch");
			req.setAttribute("mismatch","Password mismatch!!");
			RequestDispatcher rd=req.getRequestDispatcher("SignUp.jsp");
			rd.forward(req, resp);
		}
	}

}
