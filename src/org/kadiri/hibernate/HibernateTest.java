package org.kadiri.hibernate;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.naren.kadiri.dto.Address;
import org.naren.kadiri.dto.UserDetails;
import org.naren.kadiri.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();

		user.setUserName("Narendra");
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("Jeep");

		/*
		 * user.getVechicle().add(vehicle); user.getVechicle().add(vehicle1);
		 */

		vehicle.setUser(user);
		vehicle1.setUser(user);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		session.save(user);
		session.save(vehicle);
		session.save(vehicle1);
		session.getTransaction().commit();
		session.close();

	}

}
