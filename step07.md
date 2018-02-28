# Proxy Object

@Entity(name = "USER_DETAILS")
public class UserDetails {

	@Id
	@GeneratedValue
	private int userid;
	private String userName;
  ## (fetch = FetchType.EAGER)
	@ElementCollection(fetch = FetchType.EAGER)  
	@JoinTable(name = "User_Address", joinColumns = @JoinColumn(name = "User_ID"))
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
