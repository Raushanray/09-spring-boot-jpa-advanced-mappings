package com.codewitraushan.cruddemo;

import com.codewitraushan.cruddemo.dao.AppDAO;
import com.codewitraushan.cruddemo.entity.Instructor;
import com.codewitraushan.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner-> {
//			createInstructor(appDAO);
//			findInstructor(appDAO);
//			deleteInstructor(appDAO);
			findInstructorDetail(appDAO);
		};
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
