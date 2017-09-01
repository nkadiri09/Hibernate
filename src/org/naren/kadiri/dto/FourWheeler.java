package org.naren.kadiri.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity 
public class FourWheeler extends Vehicle {

	private String StringVehicle;

	public String getStringVehicle() {
		return StringVehicle;
	}

	public void setStringVehicle(String stringVehicle) {
		StringVehicle = stringVehicle;
	}

}
