package com.codewitraushan.cruddemo.dao;

import com.codewitraushan.cruddemo.entity.Instructor;
import com.codewitraushan.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);
    Instructor findInstructorById(int theid);

    void deleteInstructorById(int theid);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);
}
