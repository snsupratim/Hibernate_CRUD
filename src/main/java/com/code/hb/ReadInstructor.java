package com.code.hb;

import com.code.entity.InstructorProfile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ReadInstructor {
    private SessionFactory sessionFactory;

    public ReadInstructor(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;

        Session session=sessionFactory.getCurrentSession();

        session.beginTransaction();

        List<InstructorProfile> instructorProfiles=session.createQuery("from InstructorProfile").getResultList();
        if(instructorProfiles.size()==0){
            System.out.println("no record found");
            return;
        }
        // read one by one object from the list :
        for(InstructorProfile instructorProfile:instructorProfiles){
            System.out.println(instructorProfile.toString());
        }

        //close the session
        session.close();
    }
}
