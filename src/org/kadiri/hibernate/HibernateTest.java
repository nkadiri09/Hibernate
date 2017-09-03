package org.kadiri.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.naren.kadiri.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from org.naren.kadiri.dto.UserDetails");
		List userList = query.list();
		session.getTransaction().commit();
		session.close();
		System.out.println("size of the table is: " + userList.size());
	}
}
