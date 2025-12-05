package com.jspiders;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionDemo {
    public static void main(String[] args) {
        System.out.println("program starts");
        //load configuration
        Configuration config=new Configuration();
        config.configure("hibernate.cfg.xml");
        //build session factory
        SessionFactory  sessionFactory=config.buildSessionFactory();
        System.out.println("session factory created");
         //get session from session factory
        Session session=sessionFactory.openSession();
        System.out.println("session created");
        //logics
        //close session
        session.close();
        System.out.println("session closed");
        //close session factory
        sessionFactory.close();
        System.out.println("session factory closed");
        System.out.println("program ends");
    }
}
