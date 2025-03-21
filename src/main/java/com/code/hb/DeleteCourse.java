package com.code.hb;

import com.code.entity.Course;
import com.code.entity.InstructorProfile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DeleteCourse {
    private SessionFactory sessionFactory;
    public DeleteCourse(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
        Session session=sessionFactory.getCurrentSession();
        session.beginTransaction();

        int deleteId=1;
        Course course =session.get(Course.class,deleteId);
        if(course==null){
            System.out.println("sorry no instructor"+"found with id"+deleteId+"not found");
            return;
        }
        //display the existing value
        System.out.println("Existing Course Details");
        System.out.println("Title:"+course.getTitle());
        System.out.println("Fees:"+course.getFees());
        System.out.println("Duration:"+course.getDuration());



        //update the object instructor profile:
        session.remove(course);

        //commit:
        session.getTransaction().commit();
        //close the session:
        session.close();
        //message:
        System.out.println("Courses is deleted successfully");
    }
}
