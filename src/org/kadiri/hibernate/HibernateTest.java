package org.kadiri.hibernate;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.naren.kadiri.dto.Address;
import org.naren.kadiri.dto.FourWheeler;
import org.naren.kadiri.dto.TwoWheeler;
import org.naren.kadiri.dto.UserDetails;
import org.naren.kadiri.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {

		UserDetails user = new UserDetails();
		user.setUserName("Narendra");

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);

		user.setUserName("Update User Narendra");
		session.getTransaction().commit();
		session.close();

	}

}
