package com.springcore.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer prodId;
	private String prodName;
	private Integer prodQuantity;
	private String description;
	private Long price;
	private String imgUrl;
	
	@ManyToOne
	@JoinColumn(name="user",referencedColumnName = "userId",nullable = false)
	private Users user;
	@OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Carts> cart = new HashSet<>();




	
	
	
	
	
	
}
 