package com.code.hb;

import com.code.entity.InstructorProfile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UpdateInstructor {
    private SessionFactory sessionFactory;
    public UpdateInstructor(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
        Session session=sessionFactory.getCurrentSession();
        session.beginTransaction();

        int updateid=1;
        InstructorProfile instructorProfile=session.get(InstructorProfile.class,updateid);
        if(instructorProfile==null){
            System.out.println("sorry no instructor"+"found with id"+updateid+"not found");
            return;
        }
        //display the existing value
        System.out.println("Name:"+instructorProfile.getInstructor().getFirstname()+""+instructorProfile.getInstructor().getLastname());
        System.out.println("Email Id:"+instructorProfile.getInstructor().getEmailid());
        System.out.println("Hobby:"+instructorProfile.getHobby());
        System.out.println("Degree:"+instructorProfile.getDegree());

        //update the existing value:
        instructorProfile.getInstructor().setFirstname("abc1");
        instructorProfile.getInstructor().setLastname("cde");

        //update the object instructor profile:
        session.merge(instructorProfile);

        //commit:
        session.getTransaction().commit();
        //close the session:
        session.close();
        //message:
        System.out.println("Instructor is updated successfully");
    }
}
