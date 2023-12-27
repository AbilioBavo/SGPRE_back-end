package com.bavo.SGPRE_backend.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_address")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String province;
	private String city;
	private String distrit;
	private String zone;
	@Column(name = "stop_Place")
	private String stopPlace;
	private Integer block;
	@Column(name = "house_Number")
	private Integer houseNumber;

	@OneToMany(mappedBy = "address")
	private List<Order> orders = new ArrayList<>();

	public Address() {
	}

	public Address(Long id, String province, String city, String distrit, String zone, String stopPlace, Integer block,
			Integer houseNumber) {
		this.id = id;
		this.province = province;
		this.city = city;
		this.distrit = distrit;
		this.zone = zone;
		this.stopPlace = stopPlace;
		this.block = block;
		this.houseNumber = houseNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrit() {
		return distrit;
	}

	public void setDistrit(String distrit) {
		this.distrit = distrit;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getStopPlace() {
		return stopPlace;
	}

	public void setStopPlace(String stopPlace) {
		this.stopPlace = stopPlace;
	}

	public Integer getBlock() {
		return block;
	}

	public void setBlock(Integer block) {
		this.block = block;
	}

	public Integer getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(Integer houseNumber) {
		this.houseNumber = houseNumber;
	}

	public List<Order> getOrders() {
		return orders;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if ((obj == null) || (getClass() != obj.getClass())) {
			return false;
		}
		Address other = (Address) obj;
		return Objects.equals(id, other.id);
	}
}

