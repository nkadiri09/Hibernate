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

		Criteria criteria = session.createCriteria(UserDetails.class);
		criteria.add(Restrictions.eq("userName", "user10"))
				.add(Restrictions.gt("userId", 10))
				.add(Restrictions.between("userId", 1, 8));
		
		List<UserDetails> userList = (List<UserDetails>) criteria.list();
		

		session.getTransaction().commit();
		session.close();

		for (UserDetails users : userList) {
			System.out.println("user details  is: " + users.getUserName());
		}

	}

}
