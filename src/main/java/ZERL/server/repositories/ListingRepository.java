package ZERL.server.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ZERL.server.models.ListingModel;

@Repository
public interface ListingRepository extends JpaRepository<ListingModel, Long> {

    @Query("SELECT * FROM listing")
    ListingModel[] getAllListings();

    @Query("SELECT * FROM listing WHERE id = :id")
    ListingModel getListingByID(@Param("id") String id);

    @Query("INSERT INTO listing (id, title, price, perks, address, description, application_link, thumbnail, gallery) VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9)")
    void createListing(double id, String title, double price, String perks, String address, String description, String application_link, String thumbnail, String[] gallery);

    @Query("UPDATE listing SET title = ?1, price = ?2, perks = ?3, address = ?4, description = ?5, application_link = ?6, thumbnail = ?7, gallery = ?8 WHERE id = ?9")
    void updateListing(String title, double price, String perks, String address, String description, String application_link, String thumbnail, String[] gallery, double id);

    @Query("DELETE FROM listing WHERE id = ?1")
    void deleteListing(double id);
}
