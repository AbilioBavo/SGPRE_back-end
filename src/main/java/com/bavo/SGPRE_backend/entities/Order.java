package com.bavo.SGPRE_backend.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_orders")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant momente;

	@ManyToOne
	private Address address;
	@ManyToOne
	@JoinColumn(name="client_id")
	private User user;

	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> orderItens = new HashSet<>();

	public Order() {
	}

	public Order(Long id, Instant momente, Address address, User user) {
		super();
		this.id = id;
		this.momente = momente;
		this.address = address;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMomente() {
		return momente;
	}

	public void setMomente(Instant momente) {
		this.momente = momente;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public User getUser() {
		return user;
	}

	public Set<OrderItem> getOrderItens() {
		return orderItens;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, momente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if ((obj == null) || (getClass() != obj.getClass())) {
			return false;
		}
		Order other = (Order) obj;
		return Objects.equals(id, other.id) && Objects.equals(momente, other.momente);
	}
}
