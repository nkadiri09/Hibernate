package org.kadiri.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.naren.kadiri.dto.Address;
import org.naren.kadiri.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		UserDetails user = (UserDetails) session.get(UserDetails.class, 1);

		session.getTransaction().commit();
		session.close();

		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();

		UserDetails user1 = (UserDetails) session2.get(UserDetails.class, 1);

		session2.getTransaction().commit();
		session2.close();

	}

}
