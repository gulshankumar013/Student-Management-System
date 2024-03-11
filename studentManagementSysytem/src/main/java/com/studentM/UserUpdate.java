package com.studentM;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/studentUpdate")
public class UserUpdate extends HttpServlet {
		
	StudentDao dao = new StudentDaoImp();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student student =new Student();
		student.setRoll(Integer.parseInt(req.getParameter("roll")));
		student.setName(req.getParameter("name"));
		student.setPhone(Long.parseLong(req.getParameter("phone")));
		student.setEmail(req.getParameter("email"));
		student.setAge(Integer.parseInt(req.getParameter("age")));
		student.setAddress(req.getParameter("address"));
		student.setPassword(req.getParameter("password"));
		String message = null;
		boolean saveStudent = false;
			
		StudentDao dao= new StudentDaoImp();
		try {
			saveStudent = dao.upadteStudent(student);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(saveStudent)
			req.getRequestDispatcher("find.jsp").forward(req,resp);
		else{
			req.setAttribute("message", message);
			req.getRequestDispatcher("error.jsp").forward(req, resp);
		}
	}
}