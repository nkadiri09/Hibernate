package org.naren.kadiri.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity 
public class TwoWheeler extends Vehicle {

	private String StreeingHandil;

	public String getStreeingHandil() {
		return StreeingHandil;
	}

	public void setStreeingHandil(String streeingHandil) {
		StreeingHandil = streeingHandil;
	}

}
