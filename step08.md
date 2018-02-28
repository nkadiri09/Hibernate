# One to One

### UserDetails.java
    @Entity(name = "USER_DETAILS")
    public class UserDetails {
      @Id @GeneratedValue
      private int userid;
      private String userName;

      @OneToOne
      @JoinColumn(name="Vehicle_Id")
      private Vehicle vehicle;	

      public Vehicle getVehicle() {
        return vehicle;
      }

      public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
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
    
### Vehicle.Java

    @Entity
    public class Vehicle {
      @Id  @GeneratedValue
      private int vehicleId;
      private String vehicleName;

      public int getVehicleId() {
        return vehicleId;
      }

      public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
      }

      public String getVehicleName() {
        return vehicleName;
      }

      public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
      } }
      
 ### HibernateTest.java
 
     public class HibernateTest {
      public static void main(String[] args) {
        UserDetails user = new UserDetails();

        user.setUserName("Narendra");
        Vehicle vehicle = new Vehicle();		
        vehicle.setVehicleName("Car");		
        user.setVehicle(vehicle);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(user);
        session.save(vehicle);
        session.getTransaction().commit();
        session.close();
      }  }
      
# One To Many

### UserDetails.java
    @Entity(name = "USER_DETAILS")
    public class UserDetails {

      @Id	@GeneratedValue
      private int userid;
      private String userName;

      @OneToMany
      @GenericGenerator(name = "hilo-gen", strategy = "hilo")
      @JoinTable(name = "User_Vechicle", joinColumns = @JoinColumn(name = "User_Id"), inverseJoinColumns = @JoinColumn(name = "Vehicle_Id"))
      @CollectionId(columns = { @Column(name = "Vehicle_SN") }, generator = "hilo-gen", type = @Type(type = "long"))
      private Collection<Vehicle> vechicle = new ArrayList<Vehicle>();

      public Collection<Vehicle> getVechicle() {
        return vechicle;
      }

      public void setVechicle(Collection<Vehicle> vechicle) {
        this.vechicle = vechicle;
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
      }}
      
### Vehicle.java

  # Same Class as above

### HibernateTest.java

    public class HibernateTest {

      public static void main(String[] args) {
        UserDetails user = new UserDetails();

        user.setUserName("Narendra");
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Car");
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleName("Jeep");

        user.getVechicle().add(vehicle);
        user.getVechicle().add(vehicle1);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(user);
        session.save(vehicle);
        session.save(vehicle1);
        session.getTransaction().commit();
        session.close();
      }}

# Many to One

### UserDetails.java

    @Entity(name = "USER_DETAILS")
    public class UserDetails {

      @Id	@GeneratedValue
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
      
### Vehicle.java

    @Entity
    public class Vehicle {

      @Id	@GeneratedValue
      private int vehicleId;
      private String vehicleName;

      @ManyToOne
      private UserDetails user;

      public UserDetails getUser() {
        return user;
      }

      public void setUser(UserDetails user) {
        this.user = user;
      }

      public int getVehicleId() {
        return vehicleId;
      }

      public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
      }

      public String getVehicleName() {
        return vehicleName;
      }

      public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
      } }


### HibernateTest.java

    public class HibernateTest {

      public static void main(String[] args) {
        UserDetails user = new UserDetails();

        user.setUserName("Narendra");
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Car");
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleName("Jeep");

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
      }}
      
# Many to Many

### Vehicle.java

    @Entity
    public class Vehicle {

      @Id
      @GeneratedValue
      private int vehicleId;
      private String vehicleName;

      @ManyToMany(mappedBy = "vechicle")
      private Collection<UserDetails> userList = new ArrayList<UserDetails>();

      public Collection<UserDetails> getUserList() {
        return userList;
      }

      public void setUserList(Collection<UserDetails> userList) {
        this.userList = userList;
      }

      public int getVehicleId() {
        return vehicleId;
      }

      public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
      }

      public String getVehicleName() {
        return vehicleName;
      }

      public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
      } }
      
### UserDetails.java

  @Entity(name = "USER_DETAILS")
  public class UserDetails {

    @Id
    @GeneratedValue
    private int userid;
    private String userName;

    @ManyToMany
    @JoinTable(name = "Vehicle_User", joinColumns = @JoinColumn(name = "User_ID"), inverseJoinColumns = @JoinColumn(name = "Vehicle_id"))
    @GenericGenerator(name = "hilo-gen", strategy = "hilo")
    @CollectionId(columns = { @Column(name = "SNO") }, generator = "hilo-gen", type = @Type(type = "long"))
    private Collection<Vehicle> vechicle = new ArrayList<Vehicle>();

    public Collection<Vehicle> getVechicle() {
      return vechicle;
    }

    public void setVechicle(Collection<Vehicle> vechicle) {
      this.vechicle = vechicle;
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
    
### Hibernate.java

    public class HibernateTest {

      public static void main(String[] args) {

        UserDetails user = new UserDetails();
        user.setUserName("Narendra");
        UserDetails user1 = new UserDetails();
        user1.setUserName("Divya");

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Car");
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleName("Jeep");

        user.getVechicle().add(vehicle);
        user.getVechicle().add(vehicle1);
        user1.getVechicle().add(vehicle);
        user1.getVechicle().add(vehicle1);

        vehicle.getUserList().add(user);
        vehicle1.getUserList().add(user1);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(user);
        session.save(user1);
        session.save(vehicle);
        session.save(vehicle1);
        session.getTransaction().commit();
        session.close();
        } }
