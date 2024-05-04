package ZERL.server.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    
    @Column(columnDefinition = "TEXT")
    public String username;
    
    @Column(columnDefinition = "TEXT")
    public String password;

    public Boolean validate() {

        if (
            this.username != null || this.username != "" &&
            this.password != null || this.password != ""
        ) {
            return true;
        } else {
            return false;
        }
    }

    public Admin() {}
}
