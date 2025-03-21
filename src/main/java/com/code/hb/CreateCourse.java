package com.code.hb;

import com.code.entity.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.code.entity.Instructor;

public class CreateCourse {

    private SessionFactory sessionFactory;

    // 1: Constructor with SessionFactory Object
    public CreateCourse(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

        // 2: Create the session object
        Session session = sessionFactory.getCurrentSession();

        // 3: Start the transaction
        session.beginTransaction();

        // create course:
        Instructor instructor1=session.get(Instructor.class,3);

        if(instructor1 != null){
            Course course1=new Course("Java",400.00,"3 months",instructor1);
            Course course2=new Course("Python",800.00,"3 months",instructor1);
            Course course3=new Course("C++",1200.00,"3 months",instructor1);

            //persist the course:
            session.persist(course1);
            session.persist(course2);
            session.persist(course3);

            System.out.println("3 courses have been created");

        }else{
            System.out.println("Instructor not found with ID 1 ");
        }

        session.getTransaction().commit();

        session.close();

        System.out.println("All cousres have been created");


    }
}