package test.learnjersey;

import java.util.ArrayList;
import java.util.List;

import test.learnjersey.Course;

public class CourseRepository {
	private List<Course> courseList;
	
	public CourseRepository() {
		courseList = new ArrayList<>();
		
		Course course1 = new Course();
		course1.setName("SDM");
		course1.setCode(6441);
		
		Course course2 = new Course();
		course2.setName("SPM");
		course2.setCode(6461);
		
		courseList.add(course1);
		courseList.add(course2);
	}
	
	public List<Course> getCourses(){
		return courseList;
	}
	
	public Course getCourseByCode(int code) {
		
		for(Course course : courseList){
			if(course.getCode() == code)
				return course;
		}
		return null;
	}

	public void create(Course c1) {
		// TODO Auto-generated method stub
		courseList.add(c1);
	}
}
