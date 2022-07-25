package com.example.springbasics.repositories.specifications;

import com.example.springbasics.entities.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductsSpecifications {
    public static Specification<Product> costGreaterOrEqualsThan (Integer cost) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("cost"), cost);
    }

    public static Specification<Product> costLessOrEqualsThan (Integer cost) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("cost"), cost);
    }

    public static Specification<Product> titleLike(String titlePart) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), String.format("%%%s%%", titlePart));
    }

    public static Specification<Product> equalCategory(Long categoryId) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("category").get("id"), categoryId);
    }
}
