package com.studentM;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/delete")
public class DeleteController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id =req.getParameter("id");
		StudentDao dao= new StudentDaoImp();
		try {
		Student student = dao.findStudentById(id);
		if(student!=null) {
			boolean message=dao.deleteStudent(id);
			if(message)
				req.setAttribute("message","data deleted");
			req.getRequestDispatcher("home.jsp").forward(req, resp);
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
