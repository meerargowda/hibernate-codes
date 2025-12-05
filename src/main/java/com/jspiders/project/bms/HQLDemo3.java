package com.jspiders.project.bms;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class HQLDemo3 {
    public static void main(String[] args) {

        Configuration config = new Configuration();
        config.configure("hibernate.bms.cfg.xml");

        //build session factory
        SessionFactory sessionFactory = config.buildSessionFactory();
        System.out.println("sessionFactory created..");

        //get session from session factory
        Session session = sessionFactory.openSession();//connect to db
        System.out.println("session created..");
        Scanner scanner=new Scanner(System.in);

        //logics FROM Entity ref WHERE ref.dataMember = value;
        String selectMovieByName_HQL2 = "FROM Movie mv WHERE mv.status = :status";
        Query<Movie> query = session.createQuery(selectMovieByName_HQL2, Movie.class);

        System.out.println("enter movie status to search");
        String status=scanner.next();
        query.setParameter("status",MovieStatus.valueOf(status));
        List<Movie> movie = query.getResultList();
        for (int i=0;i< movie.size();i++){
            Movie mv=movie.get(i);
            System.out.println(mv);
        }



        //close session
        session.close();
        System.out.println("session closed..");
        //close session factory
        sessionFactory.close();
        System.out.println("sessionFactory closed..");

        System.out.println("Program ends...");
    }
}

