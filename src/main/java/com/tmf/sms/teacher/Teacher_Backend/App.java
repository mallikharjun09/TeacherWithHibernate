package com.tmf.sms.teacher.Teacher_Backend;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.tmf.sms.teacher.Teacher_Backend.models.Teacher;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        StandardServiceRegistry service = new StandardServiceRegistryBuilder().
        									configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(service).buildMetadata();
        SessionFactory factory = meta.buildSessionFactory();
        
        System.out.println("Session Factory has been created...");
        
        Session ses = factory.openSession();
        
        Teacher tea = new Teacher();
        tea.setEmail("bankuruchetankumar801@gmail.com");
        tea.setGender("Male");
        tea.setPhoneNumber(6309880227L);
        tea.setQualification("B.Sc (MPCS)");
        tea.setSalary(18000);
        tea.setSubjects("Physics, Computers, Maths");
        tea.setTeacherName("Bankuru Chetan Kumar");
        
        
        Transaction tx = ses.beginTransaction();
        ses.save(tea);
        tx.commit();
        ses.close();
    }
}
