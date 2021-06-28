package com.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.hibernate.Transaction;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Project Started");

		// Configuration cfg = new Configuration();
		// cfg.configure();
		// SessionFactory factory = cfg.buildSessionFactory();

		// or

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		// System.out.println(factory);
		// System.out.println(factory.isClosed());

		Student s1 = new Student();

		s1.setSid(102);
		s1.setName("Yokta");
		s1.setCity("Tokiyo");

		
		//creating object of Address class
		Address ad = new Address();
		
		ad.setStreet("street1");
		ad.setCity("Pune");
		ad.setOpen(true);
		ad.setAddressDate(new Date());
		ad.setX(123.12);
		
		//to set image
		FileInputStream fis = new FileInputStream("src/main/java/im.svg");
		byte[] data = new byte[fis.available()];
		fis.read(data);
		ad.setImage(data);
		
		// create session to set object t database
		Session session = factory.openSession();

		Transaction tx =  session.beginTransaction();
		session.save(s1); // save object to databases
		session.save(ad);
		tx.commit();
		session.close();

	}
}
