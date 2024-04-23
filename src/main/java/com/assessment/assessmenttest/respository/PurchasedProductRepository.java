package com.assessment.assessmenttest.respository;

import com.assessment.assessmenttest.entity.PurchasedProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchasedProductRepository extends JpaRepository<PurchasedProduct, Long> {
}
