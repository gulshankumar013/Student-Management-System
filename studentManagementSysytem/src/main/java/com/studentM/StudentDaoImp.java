package com.studentM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.mysql.cj.jdbc.PreparedStatementWrapper;

public class StudentDaoImp implements StudentDao {

	@Override
	public boolean saveStudent(Student student) {
	Connection connection = ConnectionToDatabase.getConnection();
	try {
	PreparedStatement prepareStatement;
	
		prepareStatement = connection.prepareStatement("insert into student value (?,?,?,?,?,?,?)");
		prepareStatement.setInt(1,student.getRoll());
		prepareStatement.setString(2,student.getName());
		prepareStatement.setLong(3, student.getPhone());
		prepareStatement.setString(4, student.getEmail());
		prepareStatement.setInt(5, student.getAge());
		prepareStatement.setString(6,student.getAddress());
		prepareStatement.setString(7,student.getPassword());
		int execute = prepareStatement.executeUpdate();
		if(execute>0)
			return true;
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
		
		return false;
	}

	@Override
	public boolean upadteStudent(Student student) throws SQLException {
		Connection connection = ConnectionToDatabase.getConnection();
		
		PreparedStatement prepareStatement;
		prepareStatement = connection.prepareStatement("update student set id=?,name=?,email=?,phone=?,password=?,address=?,age=? where id=?");
		prepareStatement.setLong(1, student.getRoll());
		prepareStatement.setLong(8, student.getRoll());
		prepareStatement.setString(2,student.getName());
		prepareStatement.setString(3, student.getEmail());
		prepareStatement.setLong(4,student.getPhone() );
		prepareStatement.setString(5,student.getPassword());
		prepareStatement.setString(6,student.getAddress());
		prepareStatement.setLong(7, student.getAge());
		int execute = prepareStatement.executeUpdate();
		
		if(execute>0)
			return true;
		return false;
	}

	@Override
	public boolean deleteStudent(String id) throws SQLException {
      Connection connection = ConnectionToDatabase.getConnection();
		PreparedStatement prepareStatement;
		prepareStatement = connection.prepareStatement("delete from student where id=?");
		prepareStatement.executeUpdate();
		return false;
	}

	@Override
	public Student findStudentById(int id) {
		try {
			Statement statement=new ConnectionToDatabase().getConnection().createStatement();
			ResultSet rs=statement.executeQuery("select * from student where id =" + id);
			if(rs!=null && rs.next()) {
			
				Student s=new Student();
				s.setRoll(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setPhone(rs.getLong(3));
				s.setEmail(rs.getString(4));
				s.setAge(rs.getInt(5));
				s.setAddress(rs.getString(6));
				s.setPassword(rs.getString(7));
				
				
				
				return s;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Student> findAllStudent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
//	public Student findStudentById(Student student) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
	public boolean upadteStudent(StudentDao student) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Student findStudentById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student findStudentById() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Student findStudentById(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteStudent(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

}
