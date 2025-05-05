package dev.rme.repository;

import dev.rme.model.database.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("INSERT INTO Product (id, price, shopName, couponPrice, inventory, title, mainImageUrl)" +
            "VALUES (:id, :price, :shopName, :couponPrice, :inventory, :title, :mainImageUrl)")
    @Modifying
    @Transactional
    void insert(@Param("id") Long id, @Param("price") Double price, @Param("shopName") String shopName, @Param("couponPrice") Double couponPrice,
                @Param("inventory") Integer inventory, @Param("title") String title, @Param("mainImageUrl") String mainImageUrl);
}
