package ZERL.server.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import jakarta.transaction.Transactional;

import ZERL.server.models.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    @Query(value = "SELECT a.password FROM Admin a WHERE a.username = ?1", nativeQuery = true)
    String authenticateAdmin(String username);

    @Transactional
    @Query(value = "INSERT INTO Admin (username, password) VALUES " +
        "( " +
        ":#{#admin.username}, " +
        ":#{#admin.password} " +
        ") RETURNING *", nativeQuery = true)
    public abstract Admin createAdmin(@Param("admin") Admin admin);

    @Transactional
    @Query(value = "UPDATE Admin SET " +
        "password = :#{#admin.password} " +
        "WHERE username = :#{#admin.username} RETURNING *",
    nativeQuery = true)
    public abstract Admin updatePassword(@Param("admin") Admin admin);
}
