package com.code.hb;

import com.code.entity.Course;
import com.code.entity.InstructorProfile;
import com.code.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ReadStudent {
    private SessionFactory sessionFactory;

    public ReadStudent(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;

        Session session=sessionFactory.getCurrentSession();

        session.beginTransaction();

        List<Student> students=session.createQuery("from Student", Student.class).getResultList();
        if(students.size()==0){
            System.out.println("no record found");
            return;
        }
        // read one by one object from the list :
        for(Student student : students){
            System.out.println(student.toString());
        }

        session.getTransaction().commit();

        //close the session
        session.close();
    }
}
