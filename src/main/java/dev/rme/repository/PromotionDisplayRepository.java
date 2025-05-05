package dev.rme.repository;

import dev.rme.model.database.PromotionDisplay;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionDisplayRepository extends JpaRepository<PromotionDisplay, Long> {
    @Query(value = "INSERT INTO promotion_display (id_product, type_name) VALUES (:idProduct, :typeName)",
            nativeQuery = true)
    @Modifying
    @Transactional
    void insert(@Param("idProduct") Long idProduct, @Param("typeName") String typeName);
}
