package ZERL.server.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;
import jakarta.transaction.Transactional;

import java.util.List;

import ZERL.server.models.Listing;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Long> {

    @Query("SELECT l FROM Listing l")
    List<Listing> getAllListings();

    @Query("SELECT l FROM Listing l WHERE l.id = ?1")
    Listing getListingByID(String id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Listing (id, title, price, perks, address, description, application_link, thumbnail, gallery) VALUES " +
    "( " +
        ":#{#listing.title}, " +
        ":#{#listing.price}, " +
        ":#{#listing.perks}, " +
        ":#{#listing.address}, " +
        ":#{#listing.description}, " +
        ":#{#listing.application_link}, " +
        ":#{#listing.thumbnail}, " +
        ":#{#listing.gallery} " +
    ")", nativeQuery = true)
    public abstract void createListing(@Param("listing") Listing listing);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Listing SET " +
        "title = :#{#listing.title}, " +
        "price = :#{#listing.price}, " +
        "perks = ?3, " +
        "address = ?4, " +
        "description = ?5, " +
        "application_link = ?6, " +
        "thumbnail = ?7, " +
        "gallery = ?8 " +
        "WHERE id = ?9",
    nativeQuery = true)
    void updateListing(@Param("listing") Listing listing);

    @Query("DELETE FROM Listing WHERE id = ?1")
    void deleteListing(double id);
}
