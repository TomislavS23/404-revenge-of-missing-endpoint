package dev.rme.repository;

import dev.rme.model.database.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("FROM Product")
    Optional<List<Product>> findAllProducts();

    @Query("FROM Product WHERE id = :id")
    Optional<Product> findProductById(@Param("id") BigInteger id);

    @Query("INSERT INTO Product (id, price, shopName, couponPrice, inventory, title, mainImageUrl)" +
            "VALUES (:id, :price, :shopName, :couponPrice, :inventory, :title, :mainImageUrl)")
    @Modifying
    @Transactional
    void insert(@Param("id") Long id, @Param("price") Double price, @Param("shopName") String shopName, @Param("couponPrice") Double couponPrice,
                @Param("inventory") Integer inventory, @Param("title") String title, @Param("mainImageUrl") String mainImageUrl);

    @Modifying
    @Transactional
    @Query(value = "UPDATE product SET price = :price WHERE id = :id", nativeQuery = true)
    void update(@Param("id") BigInteger id, @Param("price") Double price);

    @Modifying
    @Transactional
    @Query("DELETE Product WHERE id = :id")
    void delete(@Param("id") BigInteger id);
}
