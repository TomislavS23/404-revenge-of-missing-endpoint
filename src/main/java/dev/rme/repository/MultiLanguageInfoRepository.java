package dev.rme.repository;

import dev.rme.model.database.MultiLanguageInfo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface MultiLanguageInfoRepository extends JpaRepository<MultiLanguageInfo, Long> {
    @Query(value = "INSERT INTO multi_language_info (id_product, language, title) VALUES (:id, :language, :title)",
            nativeQuery = true)
    @Modifying
    @Transactional
    void insert(@Param("id") Long id, @Param("language") String language, @Param("title") String title);

    @Query(value = "DELETE FROM multi_language_info WHERE id_product = :id", nativeQuery = true)
    @Modifying
    @Transactional
    void delete(@Param("id") BigInteger id);
}
