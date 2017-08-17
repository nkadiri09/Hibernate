package org.kadiri.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.naren.kadiri.dto.Address;
import org.naren.kadiri.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();

		// user.setUserid(1);
		user.setUserName("Narendra");
		Address address = new Address();
		address.setStreet("213");
		address.setCity("Horsham");
		address.setState("PA");
		address.setPin("19044");
		user.setAddress(address);

		/*UserDetails user2 = new UserDetails();
		user2.setUserName("Narendra-2");*/
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
		System.out.println("User we are retriving is: " + user.getUserName());

	}

}
