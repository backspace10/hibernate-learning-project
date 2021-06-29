package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbbedDemo {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Student s1 = new Student();

		s1.setSid(105);
		s1.setName("Hina");
		s1.setCity("Hiroshima");

		Certificate c1 = new Certificate();
		c1.setCourse("java");
		c1.setDuration("5 months");

		s1.setCerti(c1);

		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();

		s.save(s1);

		tx.commit();
		s.close();
		factory.close();

	}

}
