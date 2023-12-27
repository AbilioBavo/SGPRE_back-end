package com.bavo.SGPRE_backend.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_itens")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Column(name = "short_Description")
	private String shortDescription;
	@Column(name = "long_Description")
	private String longDescription;
	private Double price;
	@Column(name = "img_Url")
	private String imgUrl;
	@Column(name = "total_Stock")
	private Integer totalStock;

	@ManyToOne
	private Category category;

	@OneToMany(mappedBy = "id.item")
	private Set<OrderItem> orderItens = new HashSet<>();

	public Item() {
	}

	public Item(Long id, String name, String shortDescription, String longDescription, Double price, String imgUrl,
			Integer totalStock, Category category) {
		this.id = id;
		this.name = name;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.price = price;
		this.imgUrl = imgUrl;
		this.totalStock = totalStock;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Integer getTotalStock() {
		return totalStock;
	}

	public void addStock(Integer quantity) {
		this.totalStock += quantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<OrderItem> getOrderItens() {
		return orderItens;
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
		Item other = (Item) obj;
		return Objects.equals(id, other.id);
	}
}

