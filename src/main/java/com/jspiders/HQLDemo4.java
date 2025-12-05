package com.jspiders;

import com.jspiders.project.bms.Movie;
import com.jspiders.project.bms.MovieStatus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaPredicate;
import org.hibernate.query.criteria.JpaRoot;

import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class HQLDemo4 {
   private static Scanner scanner=new Scanner(System.in);
    public static void login(){
        Configuration config = new Configuration();
        config.configure("hibernate.bms.cfg.xml");

        //build session factory
        SessionFactory sessionFactory = config.buildSessionFactory();
        System.out.println("sessionFactory created..");

        System.out.println("enter your title");
        String title=scanner.next();
        System.out.println("enter id");
        String id=scanner.next();

        Session session = sessionFactory.openSession();//connect to db
        System.out.println("session created..");


        HibernateCriteriaBuilder cb = session.getCriteriaBuilder();

        // step2--->create dynamic-query using CriteriaBuilder with entity class
        JpaCriteriaQuery<Movie> query = cb.createQuery(Movie.class);

        //step3---->define the table name
        JpaRoot<Movie> table = query.from(Movie.class);

        // step4--->define the condition/criteria
        JpaPredicate condition1 = cb.equal(table.get("status"), MovieStatus.AVAILABLE);
        JpaPredicate condition2 = cb.equal(table.get("title"), title);

        // step5---.build the query using the table and condition
        query.select(table).where(condition1,condition2);

        Query<Movie> query1 = session.createQuery(query);
        List<Movie> resultList = query1.getResultList();
        for (Movie mov:resultList){
            System.out.println(mov);
        }

        query1.setParameter("title",title);
        query1.setParameter("id",id);

        //close session
        session.close();
        System.out.println("session closed..");
        //close session factory
        sessionFactory.close();
        System.out.println("sessionFactory closed..");

    }
    public static void main(String[] args) {
        login();
    }
}
