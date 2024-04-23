package com.assessment.assessmenttest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SequenceGenerator(
	name = "purchased_product_seq_generator",
	sequenceName = "purchased_product_seq",
	allocationSize = 1)
public class PurchasedProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "purchased_product_seq_generator")
	private Long id;


}
