package com.code.hb;

import com.code.entity.InstructorProfile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.code.entity.Instructor;

public class CreateInstructor {

    private SessionFactory sessionFactory;

    // 1: Constructor with SessionFactory Object
    public CreateInstructor(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

        // 2: Create the session object
        Session session = sessionFactory.getCurrentSession();

        // 3: Start the transaction
        session.beginTransaction();

        // Example: Creating Courses for Instructor ID 1 (3 courses for Instructor 1)

        // Get Instructor with ID 1 (you can change this ID as needed);
        Instructor instructor = new Instructor("ABC1", "CDE", "ABC1@gmail.com");
        InstructorProfile instructorProfile = new InstructorProfile("abc", "cde", "efd", instructor);
        session.persist(instructorProfile);

         instructor = new Instructor("ABC2", "CDE", "ABC2@gmail.com");
         instructorProfile = new InstructorProfile("abc", "cde", "efd", instructor);
        session.persist(instructorProfile);

         instructor = new Instructor("ABC3", "CDE", "ABC3@gmail.com");
        instructorProfile = new InstructorProfile("abc", "cde", "efd", instructor);
        session.persist(instructorProfile);

        session.getTransaction().commit();

        session.close();

        System.out.println("instructor is created successfully "+"with id " + instructor.getId());


    }
}