package ZERL.server.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AdminModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    public String username;
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

    public AdminModel() {}
}
