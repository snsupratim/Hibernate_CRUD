package com.code.hb;

import com.code.entity.Course;
import com.code.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CreateStudent {
    private SessionFactory sessionFactory;
    public CreateStudent(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
        Session session=sessionFactory.getCurrentSession();

        session.beginTransaction();

        Student student=new Student("ABCD","XXX","ABCD@gmail.com","1234567892");

        List < Course> courses=session.createQuery("from Course").getResultList();

        //java

        Course course=courses.stream().filter(
                c->c.getTitle().equalsIgnoreCase("Python")).findAny().
                orElse(null);
//        // add course to student
        student.addCourse(course);
        course=courses.stream().filter(
                        c->c.getTitle().equalsIgnoreCase("C++")).findAny().
                orElse(null);
//        // add course to student
        student.addCourse(course);
        //save the object
        session.persist(student);
        //commit
        session.getTransaction().commit();
        //close
        session.close();
        //messages
        System.out.println("Student is created successfully with id "+student.getStudentid());

    }
}
