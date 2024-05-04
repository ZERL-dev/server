package ZERL.server.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ZERL.server.models.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    @Query("SELECT a FROM Admin a")
    Admin authenticateAdmin(Admin admin);

    @Query("UPDATE Admin SET username = ?1, password = ?2 WHERE id = ?3")
    void updateAdmin(Admin admin);
}
