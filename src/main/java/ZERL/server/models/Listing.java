package ZERL.server.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    
    @Column(columnDefinition = "TEXT")
    public String title;
    
    @Column(columnDefinition = "INTEGER")
    public Integer price;
    
    @Column(columnDefinition = "TEXT")
    public String perks;
    
    @Column(columnDefinition = "TEXT")
    public String address;
    
    @Column(columnDefinition = "TEXT")
    public String description;
    
    @Column(columnDefinition = "TEXT")
    public String application_link;
    
    @Column(columnDefinition = "TEXT")
    public String date;
    
    @Column(columnDefinition = "TEXT")
    public String thumbnail;
    
    @Column(columnDefinition = "TEXT[]")
    public String[] gallery;

    @Column(columnDefinition = "BOOLEAN")
    public String[] hidden;

    public Boolean validate() {

        if (
            this.title != null || this.title != "" &&
            this.price != null || this.price != 0 &&
            this.address != null || this.address != "" &&
            this.thumbnail != null || this.thumbnail != ""
        ) {
            return true;
        } else {
            return false;
        }
    }

    public Listing() {}
}
