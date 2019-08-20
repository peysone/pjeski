package com.sda.javagda22.Pjeski.domain.repository;

import com.sda.javagda22.Pjeski.domain.model.User;
import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
    boolean existsByEmail(String email);

    User findUserById (Long id);

    @Modifying
    @Query("UPDATE User u SET u.password = :newPassword WHERE u.email = :email")
    void updateUserPassword(@Param("newPassword") String password, @Param("email") String email);

    @Modifying
    @Query(value = "UPDATE user_role ur SET ur.role_id = :roleId WHERE ur.user_id = :id", nativeQuery = true)
    void updateUserRole(@Param("roleId") int roleNr, @Param("id") Long id);

    @Modifying
    @Query("UPDATE User u SET u.active = :intActive WHERE u.id = :id")
    void updateUserActivity(@Param("intActive") int active, @Param("id") Long id);

    @Modifying
    @Query(value = "DELETE FROM user_role WHERE user_id = :id", nativeQuery = true)
    void deleteUserFromUserRole(@Param("id") Long id);

    @Modifying
    @Query(value = "DELETE FROM user WHERE user_id = :id", nativeQuery = true)
    void deleteUserFromUser(@Param("id") Long id);

}
