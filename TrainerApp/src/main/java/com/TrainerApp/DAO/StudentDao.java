package com.TrainerApp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.TrainerApp.DTO.Student;
import com.TrainerApp.connector.Connector;

public class StudentDao {
	public static boolean insertStudent(Student s) {
		Connection con=null;
		PreparedStatement ps=null;
		String query="insert into student (sname,phone,mail,branch,location,password)values(?,?,?,?,?,?)";
		int res=0;
		try {
			con=Connector.requestConnection();
//			System.out.println("connection established");
			ps=con.prepareStatement(query);
//			System.out.println("platform created");
			
			ps.setString(1, s.getName());
			ps.setLong(2, s.getPhone());
			ps.setString(3, s.getMail());
			ps.setString(4, s.getBranch());
			ps.setString(5,s.getLocation() );
			ps.setString(6, s.getPassword());
			
			res=ps.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		if(res>0) {
			return true;
		}
		else {
			return false;
		}
		
		
	}
	public static Student getStudent(int sid,String password) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Student s=null;
		String query="select * from student where sid=? and password=?";
		
		try {
			con=Connector.requestConnection();
			ps=con.prepareStatement(query);
			ps.setInt(1, sid);
			ps.setString(2, password);
			rs=ps.executeQuery();
			if(rs.next()) {
				s=new Student();
				s.setSid(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setPhone(rs.getLong(3));
				s.setMail(rs.getString(4));
				s.setBranch(rs.getString(5));
				s.setLocation(rs.getString(6));
				s.setPassword(rs.getString(7));
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return s;
		
	}
	public static List<Student> getAllStudent() {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Student s=null;
		String query="select * from student ";
		ArrayList<Student> slist=new ArrayList<>();
		
		
		try {
			con=Connector.requestConnection();
			ps=con.prepareStatement(query);
			
			rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setSid(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setPhone(rs.getLong(3));
				s.setMail(rs.getString(4));
				s.setBranch(rs.getString(5));
				s.setLocation(rs.getString(6));
				s.setPassword(rs.getString(7));
				slist.add(s);
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return slist;
		
	}
	public static boolean updateStudent(Student s) {
		Connection con=null;
		PreparedStatement ps=null;
		String query="update student set sname=?,phone=?,mail=?,branch=?,location=?,password=? where sid=?";
		int res=0;
		try {
			con=Connector.requestConnection();
			ps=con.prepareStatement(query);
			ps.setString(1,s.getName());
			ps.setLong(2, s.getPhone());
			ps.setString(3, s.getMail());
			ps.setString(4, s.getBranch());
			ps.setString(5, s.getLocation());
			ps.setString(6, s.getPassword());
			ps.setInt(7, s.getSid());
			res=ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		if(res>0) {
			return true;
		}
		else {
			return false;
		}
		
	}
	public static boolean deleteStudent(Student s)
	{
	 Connection con=null;
	 PreparedStatement ps=null;
	 String query="DELETE FROM STUDENT WHERE SID=?";
	 int res=0;
	 try {
	 con=Connector.requestConnection();
	 ps=con.prepareStatement(query);
	 ps.setInt(1, s.getSid());
	 res=ps.executeUpdate(); 
	 }
	 catch (ClassNotFoundException | SQLException e) {
	 e.printStackTrace();
	 }
	 if(res>0)
	 {
	 return true;
	 }
	 else
	 {
	 return false;
	 }
	}
	public static Student getStudent(long phone) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Student s=null;
		String query="select * from student where phone=?";
		
		try {
			con=Connector.requestConnection();
			ps=con.prepareStatement(query);
			ps.setLong(1, phone);
			
			rs=ps.executeQuery();
			if(rs.next()) {
				s=new Student();
				s.setSid(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setPhone(rs.getLong(3));
				s.setMail(rs.getString(4));
				s.setBranch(rs.getString(5));
				s.setLocation(rs.getString(6));
				s.setPassword(rs.getString(7));
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return s;
	}

}

