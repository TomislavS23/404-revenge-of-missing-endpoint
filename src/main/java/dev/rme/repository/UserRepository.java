package dev.rme.repository;

import dev.rme.model.database.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("FROM User")
    Optional<List<User>> findAllUsers();

    @Query("FROM User u WHERE u.id = :id")
    Optional<User> findUserById(@Param("id") Integer id);

    @Query("FROM User u WHERE u.username = :username")
    Optional<User> findUserByUsername(@Param("username") String username);

    @Modifying
    @Transactional
    @Query("UPDATE User SET username = :username, email = :email WHERE id = :id")
    void update(@Param("username") String username, @Param("email") String email, @Param("id") Integer id);

    @Modifying
    @Transactional
    @Query("UPDATE User SET hashedPassword = :password, salt = :salt WHERE username = :username")
    void changePassword(@Param("password") byte[] password, @Param("salt") byte[] salt, @Param("username") String username);

    @Modifying
    @Transactional
    @Query("DELETE User WHERE id = :id")
    void delete(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query("INSERT INTO User (username, hashedPassword, salt, email) VALUES (:username, :password, :salt, :email)")
    void insert(@Param("username") String username,
                @Param("password") byte[] password,
                @Param("salt") byte[] salt,
                @Param("email") String email
    );
}
