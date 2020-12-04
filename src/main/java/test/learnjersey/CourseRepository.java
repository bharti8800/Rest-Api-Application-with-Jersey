package test.learnjersey;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import test.learnjersey.Course;

public class CourseRepository {

	Connection con;
	public CourseRepository() {
		String url = "jdbc:mysql://localhost:3306/restApiTest";
		String username = "root";
		String password = "password";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public List<Course> getCourses(){
		List<Course> courseList = new ArrayList<>();
		String sql = "Select * from course";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Course course = new Course();
				course.setName(rs.getString(2));
				course.setCode(Integer.parseInt(rs.getString(1)));
		
				courseList.add(course);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return courseList;
	}
	
	public Course getCourseByCode(int code) {
		List<Course> courseList = getCourses();
		for(Course course : courseList){
			if(course.getCode() == code)
				return course;
		}
		return null;
	}

	public void create(Course c1) {
		String name = c1.getName();
		int code = c1.getCode();
		
		try {
			Statement stmt = con.createStatement();
			String sql = "Insert into course values ( " + code + ",'" + name + "')";
			
			stmt.executeUpdate(sql);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void update(Course c1) {
		String sql = "update course set name = ? where code = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, c1.getName());
			stmt.setInt(2, c1.getCode());
			
			stmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void delete(int code) {
		String sql = "Delete from course Where code = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, code);
			stmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
