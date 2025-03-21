package com.code.hb;

import com.code.entity.InstructorProfile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DeleteInstructor {
    private SessionFactory sessionFactory;
    public DeleteInstructor(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
        Session session=sessionFactory.getCurrentSession();
        session.beginTransaction();

        int deleteId=1;
        InstructorProfile instructorProfile=session.get(InstructorProfile.class,deleteId);
        if(instructorProfile==null){
            System.out.println("sorry no instructor"+"found with id"+deleteId+"not found");
            return;
        }
        //display the existing value
        System.out.println("Name:"+instructorProfile.getInstructor().getFirstname()+""+instructorProfile.getInstructor().getLastname());
        System.out.println("Email Id:"+instructorProfile.getInstructor().getEmailid());
        System.out.println("Hobby:"+instructorProfile.getHobby());
        System.out.println("Degree:"+instructorProfile.getDegree());



        //update the object instructor profile:
        session.remove(instructorProfile);

        //commit:
        session.getTransaction().commit();
        //close the session:
        session.close();
        //message:
        System.out.println("Instructor is deleted successfully");
    }
}
