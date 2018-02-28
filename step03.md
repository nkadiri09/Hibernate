# Embeddable value object

If we want to add the Address object variables to save as a userDetails (variables) table Columns we can do with @Embeddable in Address
Object or defin the Address Object (@Embidded Private Address address). so hibernate creats the table name with UserDetails with
following fields

UserDetails:
  userid;
	userName;
  street;
	city;
	State;
	pin;

 # hibernate.cfg.xml

<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE hibernate-configuration PUBLIC
"-//Hibernate/Hibernate Configuration DTD 3.0//EN"
"http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
	<session-factory>
		<!-- Database connection settings -->
		<property name="connection.driver_class">com.mysql.jdbc.Driver</property>
		<property name="connection.url">jdbc:mysql://localhost:3306/hibernatedatabase</property>
		<property name="connection.username">root</property>
		<property name="connection.password"></property>

		<!-- JDBC connection pool (use the built-in) -->
		<property name="connection.pool_size">1</property>

		<!-- SQL dialect -->
		<property name="dialect">org.hibernate.dialect.MySQLDialect</property>

		<!-- Enable Hibernate's automatic session context management -->
		<property name="current_session_context_class">thread</property>

		<!-- Disable the second-level cache -->
		<property name="cache.provider_class">org.hibernate.cache.NoCacheProvider</property>

		<!-- Echo all executed SQL to stdout -->
		<property name="show_sql">true</property>

		<!-- Drop and re-create the database schema on startup -->
		<property name="hbm2ddl.auto">create</property>

		<mapping class="org.naren.kadiri.dto.UserDetails" />

	</session-factory>
</hibernate-configuration>


# HibernateTest.java

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

	} }

# Address.java

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String street;
	private String city;
	private String state;
	private String pin;

  // setter getters...  }

# UserDetails

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "USER_DETAILS")
public class UserDetails {

	@Id
	@GeneratedValue // @Column(name = "User_ID")
	private int userid;
	private String userName;
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	} }


