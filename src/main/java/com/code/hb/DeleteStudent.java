package com.code.hb;

import com.code.entity.Course;
import com.code.entity.InstructorProfile;
import com.code.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DeleteStudent {
    private SessionFactory sessionFactory;
    public DeleteStudent(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
        Session session=sessionFactory.getCurrentSession();
        session.beginTransaction();

        int deleteId=1;
        Student student =session.get(Student.class,deleteId);
        if(student==null){
            System.out.println("sorry no instructor"+"found with id"+deleteId+"not found");
            return;
        }
        System.out.println("Existing Course Details");
        System.out.println("First Name:"+student.getFname());
        System.out.println("Last Name:"+student.getLname());
        System.out.println("Email:"+student.getEmailid());



        //update the object instructor profile:
        session.remove(student);

        //commit:
        session.getTransaction().commit();
        //close the session:
        session.close();
        //message:
        System.out.println("Student is deleted successfully");
    }
}
