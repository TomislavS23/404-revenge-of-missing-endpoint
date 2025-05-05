package dev.rme.model.database;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Size(max = 255)
    @Column(name = "shop_name")
    private String shopName;

    @ColumnDefault("0.00")
    @Column(name = "coupon_price", precision = 10, scale = 2)
    private BigDecimal couponPrice;

    @ColumnDefault("0")
    @Column(name = "inventory")
    private Integer inventory;

    @Column(name = "title", length = Integer.MAX_VALUE)
    private String title;

    @Column(name = "main_image_url", length = Integer.MAX_VALUE)
    private String mainImageUrl;

}