package com.jspiders.project.bms.main;

import com.jspiders.project.bms.Movie;
import com.jspiders.project.bms.MovieStatus;
import com.jspiders.project.bms.Movie_MetaData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class OneToOneDemo2 {
    private static SessionFactory sessionFactory = null;

    static
    {
        //load configuration
        System.out.println("1.Load Configuration");
        Configuration config = new Configuration();
        config.configure("hibernate.bms.cfg.xml");

        //create sessionfactory
        System.out.println("2.Create SessionFactory");
        sessionFactory = config.buildSessionFactory();
    }
    public static void saveMovie()
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.println("Creating Movie data");
        Movie m1 = new Movie();
        m1.setTitle("google");
        m1.setLanguage("kannada");
        m1.setDuration(180);
        m1.setCertification("U/A");
        m1.setStatus(MovieStatus.AVAILABLE);

        System.out.println("Creating Movie_metadata data");
        Movie_MetaData meta1 = new Movie_MetaData();
        meta1.setGenere("cha");
        meta1.setFormate("ua");
        meta1.setRating(5);
        //meta1.setReleasedate(LocalDate.now());

        System.out.println("linking movie to movie meta data");
//        m1.setMovieMetaData(meta1);
        session.persist(m1);
        System.out.println("saving movie and metadata data");
        transaction.commit();
        session.close();
        System.out.println("session closed");
    }

    public static void main(String[] args) {
        System.out.println("program starts...");
        saveMovie();
        System.out.println("sessionfactory close");
        sessionFactory.close();
        System.out.println("program ends...");
    }
}