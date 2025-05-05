package dev.rme.model.database;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "promotion_info")
public class PromotionInfo {
    @Id
    @ColumnDefault("nextval('promotion_info_id_seq')")
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_promotion_display")
    private PromotionDisplay idPromotionDisplay;

    @Size(max = 255)
    @Column(name = "activity_code")
    private String activityCode;

    @Column(name = "promotion_name", length = Integer.MAX_VALUE)
    private String promotionName;

}