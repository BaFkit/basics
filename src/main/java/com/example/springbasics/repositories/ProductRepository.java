package com.example.springbasics.repositories;

import com.example.springbasics.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    Optional<Product> findByTitle(String title);

//    List<Product> findAllByCostBetweenOrderById(Integer min, Integer max);

//    @Query("SELECT p FROM Product p WHERE p.cost = (SELECT MIN(p.cost) FROM Product p)")

//    List<Product> findAllWithLowCost();
//    @Query(value = "SELECT * FROM products WHERE cost = (SELECT MIN(cost) FROM products) LIMIT 1", nativeQuery = true)

//    Product findWithLowCost();
//    @Query("SELECT p.cost FROM Product p WHERE p.title = ?1")

//    Integer hqlGetCostByTitle(String title);
//    @Query(value = "SELECT cost FROM products WHERE title = :title", nativeQuery = true)

//    Integer nativeSqlGetCostByTitle(String title);

//    @Transactional
//    @Modifying
//    @Query("UPDATE Product p set p.cost = p.cost + ?2 WHERE  p.id = ?1")
//    void changeCost(Long id, Integer delta);
}
