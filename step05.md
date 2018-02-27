## Customize JointTables Table Name and Fields

@ElementCollection: to save the value object inside the entity, if you Have more number of addresses, 
then we have to separate those addresses from actual user.

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();

		user.setUserName("Narendra");
		
		Address address = new Address();
		address.setStreet("213");
		address.setCity("Horsham");
		address.setState("PA");
		address.setPin("19044");

		Address officeAddress = new Address();
		officeAddress.setStreet("201 Passaic");
		officeAddress.setCity("Harrison");
		officeAddress.setState("NJ");
		officeAddress.setPin("01549");

		user.getListOfAddress().add(address);
		user.getListOfAddress().add(officeAddress);

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

## Address

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
  //setter getters...
  }
  
	  ## UserDetails.java

			  @Entity(name = "USER_DETAILS")
		public class UserDetails {

			@Id
			@GeneratedValue
			private int userid;
			private String userName;
			@GenericGenerator(name = "hilo-gen", strategy = "hilo")
			@ElementCollection
			@JoinTable(name = "User_Address", joinColumns = @JoinColumn(name = "User_ID"))
			@CollectionId(columns = { @Column(name = "Address_Id") }, generator = "hilo-gen", type = @Type(type = "long"))
			private Collection<Address> listOfAddress = new ArrayList<Address>();

			public Collection<Address> getListOfAddress() {
				return listOfAddress;
			}

			public void setListOfAddress(Collection<Address> listOfAddress) {
				this.listOfAddress = listOfAddress;
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
