package org.naren.kadiri.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity(name = "USER_DETAILS")
public class UserDetails {

	@Id
	@GeneratedValue
	private int userid;
	private String userName;

	/*@OneToMany
	@GenericGenerator(name = "hilo-gen", strategy = "hilo")
	@JoinTable(name = "User_Vechicle", joinColumns = @JoinColumn(name = "User_Id"), inverseJoinColumns = @JoinColumn(name = "Vehicle_Id"))
	@CollectionId(columns = { @Column(name = "Vehicle_SN") }, generator = "hilo-gen", type = @Type(type = "long"))
	private Collection<Vehicle> vechicle = new ArrayList<Vehicle>();

	public Collection<Vehicle> getVechicle() {
		return vechicle;
	}

	public void setVechicle(Collection<Vehicle> vechicle) {
		this.vechicle = vechicle;
	}*/

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
