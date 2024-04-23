package com.assessment.assessmenttest.service;

import com.assessment.assessmenttest.dto.PurchasedProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
	private static final String FAKE_PRODUCT_URL = "https://fakestoreapi.com/products";
	private final RestClient restClient;

	@Transactional(readOnly = true)
	public List<PurchasedProduct> getPurchasedProducts() {


		return List.of();
	}
}
