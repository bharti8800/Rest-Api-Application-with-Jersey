package test.learnjersey;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("courses")
public class CourseResource {
	CourseRepository courseRepository = new CourseRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Course> getCourse() {
		//System.out.println(courseRepository.getCourses());
		return courseRepository.getCourses();
	}
	
	@POST
	@Path("course")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Course createCourse(Course c1) {
		//System.out.println("hello doll");
		courseRepository.create(c1);
		return c1;
	}
	
	@Path("course/{code}")
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Course findCourse(@PathParam("code") int code) {
		return courseRepository.getCourseByCode(code);
	}
	
}