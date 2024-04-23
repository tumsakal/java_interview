package com.assessment.assessmenttest.controller;

import com.assessment.assessmenttest.dto.PurchasedProduct;
import com.assessment.assessmenttest.dto.Response;
import com.assessment.assessmenttest.service.ProductService;
import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/products")
@RequiredArgsConstructor
public class ProductController {
	private final ProductService productService;

	@RolesAllowed("ROLE_MANAGE_PRODUCT")
	@GetMapping
	public ResponseEntity<Response<PurchasedProduct>> getProducts() {
		List<PurchasedProduct> purchasedProducts = this.productService.getPurchasedProducts();

		Response<PurchasedProduct> productResponse = Response.<PurchasedProduct>builder().data(purchasedProducts).build();

		return ResponseEntity.ok(productResponse);
	}
}
