package com.project.module;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String catId;
	@NotNull(message = "Category name can not be null...!")
	@NotBlank(message = "Category cannot be blank...!")
	private String categoryName;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
	@JsonIgnore
	private List<Product> productList = new ArrayList<>();
	
	
}
