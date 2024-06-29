package org.gopal;

import org.gopal.entities.Certificate;
import org.gopal.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Student student = new Student("Gopal Kumar", Arrays.asList("1234567890", "0123456789"),"Patna");
        Student student1 = new Student("Raja Kumar", Arrays.asList("1234567890", "0123456789"),"Patna");
        FileInputStream fis = new FileInputStream("C:\\Users\\GopalKumarGuest\\Desktop\\Gopal Documents\\GopalKumarAadhar.jpg");
        int availableSize = fis.available();
        byte[] imageData = new byte[availableSize];
        fis.read(imageData);
        student.setImage(imageData);
        Certificate certificate = new Certificate("MySql","1 months");
        Certificate certificate1 = new Certificate("Java", "3 months");
        certificate1.setStudents(Arrays.asList(student,student1));
        certificate.setStudents(Arrays.asList(student,student1));
        student.setCertificates(Arrays.asList(certificate,certificate1));
//        certificate.setStudent(student);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
//        Student savedStudent = (Student)session.save(students);
        session.persist(student);
        session.persist(student1);
//        session.persist(certificate);
//        session.persist(certificate1);
//        student.setName("Java Kumar");
        session.getTransaction().commit();
//        Student student2 = session.get(Student.class, 1);
        session.close();
        sessionFactory.close();
//        student1.setName("DummyName");
//        System.out.println(student1);
    }
}
