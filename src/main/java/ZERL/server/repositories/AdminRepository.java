package ZERL.server.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;
import jakarta.transaction.Transactional;

import ZERL.server.models.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    @Query("SELECT a FROM Admin a WHERE a.username = ?1")
    Admin authenticateAdmin(Admin admin);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Admin SET " +
        "username = :#{#admin.username}, " +
        "password = :#{#admin.password} " +
        "WHERE id = :#{#admin.id} RETURNING *",
    nativeQuery = true)
    public abstract Admin updateAdmin(@Param("admin") Admin admin);
}
