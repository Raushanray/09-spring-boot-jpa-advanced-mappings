package com.codewitraushan.cruddemo.dao;

import com.codewitraushan.cruddemo.entity.Instructor;
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
}
