package dev.rme.model.database;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "multi_language_infos")
public class MultiLanguageInfo {
    @Id
    @ColumnDefault("nextval('multi_language_infos_id_seq')")
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product idProduct;

    @Size(max = 50)
    @NotNull
    @Column(name = "language", nullable = false, length = 50)
    private String language;

    @NotNull
    @Column(name = "title", nullable = false, length = Integer.MAX_VALUE)
    private String title;

}