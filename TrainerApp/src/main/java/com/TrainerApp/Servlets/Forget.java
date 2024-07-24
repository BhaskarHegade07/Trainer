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

@WebServlet("/forget")
public class Forget extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String phoneNumber=req.getParameter("phone");
	String password=req.getParameter("spassword");
	String confirmPassword=req.getParameter("cpassword");
	
	long phone=Long.parseLong(phoneNumber);
	
PrintWriter out=resp.getWriter();
	
	//jdbc implementation
	Student s=new Student();
	StudentDao sdao=new StudentDao();
	
	s=sdao.getStudent(phone);
	if(s!=null) {
		if(password.equals(confirmPassword)) {
			s.setPassword(password);
		}
		else {
			req.setAttribute("passError","Password mismatch!!");
			RequestDispatcher rd=req.getRequestDispatcher("Forget.jsp");
			rd.forward(req, resp);
			
		}
	}
	else {
		req.setAttribute("failure","Failed to update the Password!!");
		RequestDispatcher rd=req.getRequestDispatcher("Forget.jsp");
		rd.forward(req, resp);
		
	}
	boolean res=sdao.updateStudent(s);
	if(res) {
		//out.println("<h1>password updated successfully</h1>");
		req.setAttribute("success","Password Updated successfully!!");
		RequestDispatcher rd=req.getRequestDispatcher("Forget.jsp");
		rd.forward(req, resp);
	}
	
}
}
