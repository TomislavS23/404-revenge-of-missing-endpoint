package dev.rme.model.database;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @ColumnDefault("nextval('user_id_user_seq')")
    @Column(name = "id_user", nullable = false)
    private Integer id;

    @NotNull
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "uuid", nullable = false)
    private UUID uuid;

    @Size(max = 50)
    @NotNull
    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Size(max = 100)
    @NotNull
    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @NotNull
    @Column(name = "hashed_password", nullable = false)
    private byte[] hashedPassword;

    @NotNull
    @Column(name = "salt", nullable = false)
    private byte[] salt;

    @NotNull
    @ManyToOne(optional = false)
    @ColumnDefault("1")
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

}