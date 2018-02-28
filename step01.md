# /hibernate.cfg.xml

<!-- Need to configure the connection and driver in sessionFactory tag inside the hibernate.cfg.xml -->

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
		<property name="hbm2ddl.auto">update</property>

		<mapping class="org.naren.kadiri.dto.UserDetails" />

	</session-factory>
</hibernate-configuration>

# src/org/kadiri/hibernate/HibernateTest.java

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.naren.kadiri.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();

		user.setUserid(2);
		user.setUserName("Naren");

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	} }

# src/org/naren/kadiri/dto/UserDetails.java

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserDetails {

	@Id 	@GeneratedValue
	private int userid;
	private String userName;

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
