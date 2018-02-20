# @AttributeOverride.

If we have more the one Address object to be embidded then we have ti take 2 diffrent address(Home Address, Office Address) object 
variables and we can embidded in UserDetails class, all the variables save in the same table.

## HibernateTest.java 

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
		user.setHome_Address(address);
		Address officeAddress = new Address();
		officeAddress.setStreet("201 Passaic");
		officeAddress.setCity("Harrison");
		officeAddress.setState("NJ");
		officeAddress.setPin("01549");

		user.setOffice_Address(officeAddress);

		/*
		 * UserDetails user2 = new UserDetails(); user2.setUserName("Narendra-2");
		 */
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

## Address.java

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	@Column(name="Home_street")
	private String street;
	@Column(name="Home_City")
	private String city;
	@Column(name="Home_State")
	private String state;
	@Column(name="Home_PIN")
	private String pin;

  // setter getters..

}

## UserDetails.java

@Entity(name = "USER_DETAILS")
public class UserDetails {

	@Id
	@GeneratedValue
	private int userid;
	private String userName;
	private Address home_Address;
	
	@AttributeOverrides({
		@AttributeOverride(column = @Column(name= "office_Street"), name = "street"),
		@AttributeOverride(column = @Column(name= "office_City"), name = "city"),
		@AttributeOverride(column = @Column(name= "office_State"), name = "state"),
		@AttributeOverride(column = @Column(name= "office_PIN"), name = "pin")
	})
	private Address office_Address;

	public Address getHome_Address() {
		return home_Address;
	}

	public void setHome_Address(Address home_Address) {
		this.home_Address = home_Address;
	}

	public Address getOffice_Address() {
		return office_Address;
	}

	public void setOffice_Address(Address office_Address) {
		this.office_Address = office_Address;
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
	}

}

Hibernated generated table with for this with teh following fields
UserDetials:

  userid;
	userName;
  street;
	city;
	State;
	pin;
 (Office Address Variables)
  street;
	city;
	State;
	pin; 
  
  But we need to rename the field for secound Address object as follows.
  
  	@AttributeOverrides({
		@AttributeOverride(column = @Column(name= "office_Street"), name = "street"),
		@AttributeOverride(column = @Column(name= "office_City"), name = "city"),
		@AttributeOverride(column = @Column(name= "office_State"), name = "state"),
		@AttributeOverride(column = @Column(name= "office_PIN"), name = "pin")
	})
	private Address office_Address;
