package com.codewitraushan.cruddemo.dao;

import com.codewitraushan.cruddemo.entity.Instructor;
import com.codewitraushan.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDAOImpl implements AppDAO{

    //define fields for entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);

    }

    @Override
    public Instructor findInstructorById(int theid) {
      return   entityManager.find(Instructor.class,theid);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theid) {
        // retrieve the instructor
        Instructor tempInstructor = entityManager.find(Instructor.class,theid);
        //delete the instructor
        entityManager.remove(tempInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class ,theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {
        //retrieve the instructor details
        InstructorDetail theInstructorDetail = entityManager.find(InstructorDetail.class, theId);

        //delete the instructor details
        entityManager.remove(theInstructorDetail);
    }



}
