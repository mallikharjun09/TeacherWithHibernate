package com.tmf.sms.teacher.Teacher_Backend;

import java.util.List;

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
public class DisplayRecordsApp 
{
    public static void main( String[] args )
    {
        StandardServiceRegistry service = new StandardServiceRegistryBuilder().
        									configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(service).buildMetadata();
        SessionFactory factory = meta.buildSessionFactory();
        
        System.out.println("Session Factory has been created...");
        
        Session ses = factory.openSession();
       
        List<Teacher> teachers = ses.createQuery("from Teacher").list();
        for(Teacher tea : teachers) {
        	System.out.println(tea);
        }
        ses.close();
    }
}






