package com.code.hb;

import com.code.entity.Course;
import com.code.entity.InstructorProfile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UpdateCourse {
    private SessionFactory sessionFactory;
    public UpdateCourse(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
        Session session=sessionFactory.getCurrentSession();
        session.beginTransaction();

        int updateCourseId=1;
        Course course=session.get(Course.class,updateCourseId);
        if(course==null){
            System.out.println("sorry no instructor"+"found with id"+updateCourseId+"not found");
            return;
        }
        //display the existing value
        System.out.println("Existing Course Details");
        System.out.println("Title:"+course.getTitle());
        System.out.println("Fees:"+course.getFees());
        System.out.println("Duration:"+course.getDuration());

        //update the existing value:
        course.setFees(500.00);
        course.setDuration("5 months");

        //update the object instructor profile:
        session.merge(course);

        //commit:
        session.getTransaction().commit();
        //close the session:
        session.close();
        //message:
        System.out.println("Course is updated successfully");
    }
}
