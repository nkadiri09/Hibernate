package org.naren.kadiri.dto;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
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
