package com.springcore.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "address")
@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user",referencedColumnName = "userId")
	private Users user;
	private String addressLine;
	private String addressCity;
	private String addressState;
	private String addressCountry;
	private String addressPinCode;

	@OneToMany(mappedBy = "address",cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Orders> orders=new HashSet<>();
	
}
