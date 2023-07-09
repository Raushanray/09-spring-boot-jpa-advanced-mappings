package com.codewitraushan.cruddemo.dao;

import com.codewitraushan.cruddemo.entity.Instructor;

public interface AppDAO {

    void save(Instructor theInstructor);
    Instructor findInstructorById(int theid);

    void deleteInstructorById(int theid);
}
