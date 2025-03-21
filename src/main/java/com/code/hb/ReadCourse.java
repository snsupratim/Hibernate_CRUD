package com.code.hb;

import com.code.entity.Course;
import com.code.entity.InstructorProfile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ReadCourse {
    private SessionFactory sessionFactory;

    public ReadCourse(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;

        Session session=sessionFactory.getCurrentSession();

        session.beginTransaction();

        List<Course> courses=session.createQuery("from Course", Course.class).getResultList();
        if(courses.size()==0){
            System.out.println("no record found");
            return;
        }
        // read one by one object from the list :
        for(Course course : courses){
            System.out.println(course.toString());
        }

        session.getTransaction().commit();

        //close the session
        session.close();
    }
}
