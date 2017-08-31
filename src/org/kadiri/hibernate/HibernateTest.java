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

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");
		
		TwoWheeler twoWheel = new TwoWheeler();
		twoWheel.setVehicleName("Bike");
		twoWheel.setStreeingHandil("Streeing Handle");
		
		FourWheeler fourWheel = new FourWheeler();
		fourWheel.setVehicleName("Porsch");
		fourWheel.setStringVehicle("Streeing wheel");
		

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		session.save(vehicle);
		session.save(twoWheel);
		session.save(fourWheel);
		session.getTransaction().commit();
		session.close();

	}

}
