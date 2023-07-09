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
			createInstructor(appDAO);
		};
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
