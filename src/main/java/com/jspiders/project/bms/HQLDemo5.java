package com.jspiders.project.bms;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaPredicate;
import org.hibernate.query.criteria.JpaRoot;

import java.util.List;

public class HQLDemo5 {
    public static void main(String[] args) {
        //load configuration
        Configuration config = new Configuration();
        config.configure("hibernate.bms.cfg.xml");

        //build session factory
        SessionFactory sessionFactory = config.buildSessionFactory();
        System.out.println("sessionFactory created..");

        //get session from session factory
        Session session = sessionFactory.openSession();//connect to db
        System.out.println("session created..");

        //step1--->get Criteria-builder
        HibernateCriteriaBuilder cb = session.getCriteriaBuilder();

       // step2--->create dynamic-query using CriteriaBuilder with entity classs
        JpaCriteriaQuery<Movie> query = cb.createQuery(Movie.class);

         //step3---->define the table name
        JpaRoot<Movie> table = query.from(Movie.class);

        // step4--->define the condition/criteria
        JpaPredicate condition1 = cb.equal(table.get("status"), MovieStatus.AVAILABLE);
        JpaPredicate condition2 = cb.equal(table.get("title"), "movie1");

        // step5---.build the query using the table and condition
        query.select(table).where(condition1,condition2);

        Query<Movie> query1 = session.createQuery(query);
        List<Movie> resultList = query1.getResultList();
        for (Movie mov:resultList){
            System.out.println(mov);
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
