package org.kadiri.hibernate;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.naren.kadiri.dto.Address;
import org.naren.kadiri.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();

		user.setUserName("Narendra");

		Address address = new Address();
		address.setStreet("213");
		address.setCity("Horsham");
		address.setState("PA");
		address.setPin("19044");

		Address address1 = new Address();
		address1.setStreet("201 Passaic");
		address1.setCity("Harrison");
		address1.setState("NJ");
		address1.setPin("01549");

		user.getListOfAddress().add(address);
		user.getListOfAddress().add(address1);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();

		user = null;

		session = sessionFactory.openSession();
		session.beginTransaction();
		user = (UserDetails) session.get(UserDetails.class, 1);
		session.close();
		System.out.println(user.getListOfAddress().size());

	}

}
