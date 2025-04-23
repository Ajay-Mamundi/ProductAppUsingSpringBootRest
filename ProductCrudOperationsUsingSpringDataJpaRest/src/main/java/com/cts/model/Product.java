package com.cts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "products_info")
@Data
@AllArgsConstructor
public class Product {
	@Id
	@Column(name = "pid")
	@GeneratedValue
	private int productId;
	@Column(name = "pname")
	@NotBlank(message="product name can't be null or blank")
	private String productName;
	@Column(name = "pprice")
	@Min(value=100,message="Product price should be above 100")
	@Max(value=100000,message="product price must be below 1 lakh")
	private int productPrice;
	@Column(name = "pcategory")
	@Size(min=5,max=12, message="the category lenght must be between the (5,12)")
	private String productCategory;
	@Column(name = "pquantity")
	@Positive(message="Quantity cannot be in negative value")
	private int productQuantity;
	public Product(String productName, int productPrice, String productCategory, int productQuantity) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
		this.productQuantity = productQuantity;
	}
	
	public Product() {
		
	}


}
