package com.code.hb;

import com.code.entity.Course;
import com.code.entity.InstructorProfile;
import com.code.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UpdateStudent {
    private SessionFactory sessionFactory;
    public UpdateStudent(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
        Session session=sessionFactory.getCurrentSession();
        session.beginTransaction();

        int updateStudentId=1;
        Student student=session.get(Student.class,updateStudentId);
        if(student==null){
            System.out.println("sorry no instructor"+"found with id"+updateStudentId+"not found");
            return;
        }
        //display the existing value
        System.out.println("Existing Course Details");
        System.out.println("First Name:"+student.getFname());
        System.out.println("Last Name:"+student.getLname());
        System.out.println("Email:"+student.getEmailid());

        //update the existing value:
        student.setFname("abcd");


        //update the object instructor profile:
        session.merge(student);

        //commit:
        session.getTransaction().commit();
        //close the session:
        session.close();
        //message:
        System.out.println("Course is updated successfully");
    }
}
