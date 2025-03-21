package com.code.hb;

import com.code.entity.Course;
import com.code.entity.Instructor;
import com.code.entity.InstructorProfile;
import com.code.entity.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
        //Create the obj of the configuration class
        //pass the xml file
        //add the annoted class
	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
	        .addAnnotatedClass(Instructor.class)
	        .addAnnotatedClass(InstructorProfile.class)
	        .addAnnotatedClass(Course.class)
	        .addAnnotatedClass(Student.class)
	        .buildSessionFactory();

//	new CreateInstructor(sessionFactory);
//	new ReadInstructor(sessionFactory);
//	new UpdateInstructor((sessionFactory));
//new DeleteInstructor(sessionFactory);
//		new CreateCourse(sessionFactory);
//		new ReadCourse(sessionFactory);
//		new UpdateCourse(sessionFactory);
//		new DeleteCourse(sessionFactory);
//		new CreateStudent(sessionFactory);
//		new ReadStudent(sessionFactory);
//		new UpdateStudent(sessionFactory);
		new DeleteStudent(sessionFactory);
    }
}