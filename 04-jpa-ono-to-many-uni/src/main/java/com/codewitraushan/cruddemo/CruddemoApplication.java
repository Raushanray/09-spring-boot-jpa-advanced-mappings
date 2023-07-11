package com.codewitraushan.cruddemo;

import com.codewitraushan.cruddemo.dao.AppDAO;
import com.codewitraushan.cruddemo.entity.Course;
import com.codewitraushan.cruddemo.entity.Instructor;
import com.codewitraushan.cruddemo.entity.InstructorDetail;
import com.codewitraushan.cruddemo.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner-> {

			createCourseAndReviews(appDAO);
		};


	}

	private void createCourseAndReviews(AppDAO appDAO) {

		//create a course
		Course tempCourse = new Course("pacman - How to score one million points!");

		//add some reviews
		tempCourse.addReview(new Review("Greate course .. loved it!!"));
		tempCourse.addReview(new Review("Cool course ... job will done!!"));
		tempCourse.addReview(new Review("What a dumb course, you are an idiot!!"));

		//save the course... and leverage the cascade all

		System.out.println("Saving the courese..");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());

		appDAO.save(tempCourse);

		System.out.println("Done!!");

	}

	private void deleteCourse(AppDAO appDAO) {

		int theId = 10;

		System.out.println("Deleting the course :- " + theId);

		appDAO.deleteCourseById(theId);
		System.out.println("Done!!");
	}

	private void updateCourse(AppDAO appDAO) {

		int theId = 10;

		//find the course
		System.out.println("Finding Courses id :" + theId);
		Course tempCourse = appDAO.findCourseById(theId);

		//update the course
		System.out.println("Updating the course id : " +theId);
		tempCourse.setTitle("ENjoy the simple things ");

		appDAO.update(tempCourse);
		System.out.println("Done!!");

	}

	private void updateInstructor(AppDAO appDAO) {
		int theId= 1;
		//find the instructor
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		//update instructor
		System.out.println("updating the instructor id : " + theId);
		tempInstructor.setLastName("kumari");

		appDAO.update(tempInstructor);
		System.out.println("Done!!");


	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId= 1;
		//find the instructor
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("tempInstructor : " + tempInstructor);

		System.out.println("the associated courses : " + tempInstructor.getCourses());
		System.out.println("Done!!");

	}

	private void findCoursesForInstructor(AppDAO appDAO) {

		int theid= 1;
		//find the instructor
		System.out.println("Finding instructor: " + theid);
		Instructor tempInstructor = appDAO.findInstructorById(theid);

		System.out.println("tempInstructor : " + tempInstructor);

		//find courses for instructor
		System.out.println("finding courses for instructor id : " + theid);
		List<Course> courses = appDAO.findCoursesByInstructorId(theid);

		//associate the object
		tempInstructor.setCourses(courses);

		System.out.println("the associated courses : " + tempInstructor.getCourses());
		System.out.println("Done!!");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {

		int theid= 1;
		System.out.println("Finding instructor: " + theid);
		Instructor tempInstructor = appDAO.findInstructorById(theid);
		System.out.println("tempInstructor : " + tempInstructor);
		System.out.println("the associated course : " + tempInstructor.getCourses());
		System.out.println("Done!!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		//create the Instructor
		Instructor tempInstructor = new
				Instructor("Tannu","raj","tannu@gmail.com");

		//create the Instructordetails
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("http://www.youtube.com","video_game!!");


		//associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//create some course
		Course tempCourse1 = new Course("Air Guiter - the ultimate guide");
		Course tempCourse2 = new Course("the pinball masterclass");

		//add course to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		//save the instructor
		//
		//Note: this will also save the courses
		//because of CascadeType.PERSIST
		//
		System.out.println("Saving instructor : " + tempInstructor);
		System.out.println("the courses : "+ tempInstructor.getCourses());
		appDAO.save(tempInstructor);

		System.out.println("Done!!");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 3;
		System.out.println("Deleting the instructor details : " + theId);

		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Done!!");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		//get the innstructor details object
		int theId = 2;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		//print the instructor details
		System.out.println("tempInstructorDetail : " + tempInstructorDetail);

		//print the associated instructor
		System.out.println("the associated instructor : " + tempInstructorDetail.getInstructor());

		System.out.println("Done!!");

	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Deleting instructor id :- " + theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("Done!!");
	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 2;
		System.out.println("finding Instructor id :- " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor" + tempInstructor);
		System.out.println("the associated instructureDetails only " + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		/*
		//create the Instructor
		Instructor tempInstructor = new
				Instructor("Ravi","ranjan","ravi@gmail.com");

		//create the Instructordetails
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("http://www.bihar_vibes.com/youtube","love to code!!");


		 */

		//create the Instructor
		Instructor tempInstructor = new
				Instructor("sumit","kumar","sumit@gmail.com");

		//create the Instructordetails
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("http://www.bihar_vibes.com/youtube","photography");


		//associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//save the instructor
		//
		//Note:- this will also save the details object
		//because of CascadeType.ALL

		System.out.println("Saving Instructor" + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!!");
	}

}
