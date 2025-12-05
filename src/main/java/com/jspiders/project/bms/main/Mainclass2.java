
package com.jspiders.project.bms.main;

import com.jspiders.project.bms.AudiAddress;
import com.jspiders.project.bms.Auditorium;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Mainclass2 {

    static SessionFactory sessionFactory;

    static
    {
        //Step : Load Configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.bms.cfg.xml");

        //Step : Build SessionFactory
        sessionFactory = configuration.buildSessionFactory();
    }

    public static void addAudiAddress()
    {
        Session session = sessionFactory.openSession();

        //Step : Begin Transaction
        Transaction transaction = session.beginTransaction();

        Auditorium audi1 = new Auditorium();
        AudiAddress audiAddress = new AudiAddress();

        audi1.setName("Audi-1");
        audi1.setSeatrows(30);
        audi1.setSeatcolumns(6);

        audiAddress.setStreetname("street-1");
        audiAddress.setArea("HBR");
        audiAddress.setCity("BLR");
        audiAddress.setPincode(678912);

        //Linking Audi to AudiAddress
        audi1.setAudiAddress(audiAddress);

        //Save--> Insert
        session.persist(audi1);

        //Step : Commit transacton
        transaction.commit();

        session.close();
    }

    //select
    public static void getAudiDetails(Long id)
    {
        Session session = sessionFactory.openSession();

        System.out.println("Finding audi details....");

        //begin transaction
        Transaction transaction = session.beginTransaction();

        //find audi details
        Auditorium a1 = session.find(Auditorium.class,id);//Select * from audi where id = 2

        System.out.println();

        System.out.println("============Audi Details===========");
        System.out.println("Id           : "+a1.getId());
        System.out.println("Name         : "+a1.getName());
        System.out.println("Seat Rows    : "+a1.getSeatrows());
        System.out.println("Seat Columns : "+a1.getSeatcolumns());

        System.out.println("Street    : "+a1.getAudiAddress().getStreetname());
        System.out.println("Area      : "+a1.getAudiAddress().getArea());
        System.out.println("City      : "+a1.getAudiAddress().getCity());
        System.out.println("PINCODE   : "+a1.getAudiAddress().getPincode());
        System.out.println("============Audi Details===========");

        System.out.println();

        transaction.commit();
        session.close();
    }

    public static void getAudiAddress(Long id)
    {
        Session session = sessionFactory.openSession();

        System.out.println("Finding audi address....");

        //begin transaction
        Transaction transaction = session.beginTransaction();

        //find audi address
        AudiAddress ad1 = session.find(AudiAddress.class,id);//Select * from audi_address where id = ?

        System.out.println();
        System.out.println("============Audi Address Details===========");
        System.out.println("ID      : "+ad1.getId());
        System.out.println("Street  : "+ad1.getStreetname());
        System.out.println("City    : "+ad1.getCity());
        System.out.println("Area    : "+ad1.getArea());
        System.out.println("Pincode : "+ad1.getPincode());

        System.out.println("============Audi Address Details===========");

        System.out.println("============Audi Details===========");
        System.out.println("Name : "+ad1.getAuditorium().getName());
        System.out.println("Rows : "+ad1.getAuditorium().getSeatrows());
        System.out.println("Columns : "+ad1.getAuditorium().getSeatcolumns());
        System.out.println("============Audi Details===========");
        System.out.println();

        session.close();
    }

    public static void main(String[] args) {

        System.out.println("Program starts...");

        //addAudiAddress();

        // getAudiDetails(1l);

        getAudiAddress(1l);

        //Step : Close SessionFactory
        sessionFactory.close();

        System.out.println("Program ends...");

    }
}
