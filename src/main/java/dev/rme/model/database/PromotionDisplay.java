package dev.rme.model.database;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "promotion_display")
public class PromotionDisplay {
    @Id
    @ColumnDefault("nextval('promotion_display_id_seq')")
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product idProduct;

    @Size(max = 255)
    @Column(name = "type_name")
    private String typeName;

}