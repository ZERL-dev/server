package ZERL.server.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import jakarta.transaction.Transactional;
import java.util.List;

import ZERL.server.models.Listing;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Long> {

    @Query("SELECT l FROM Listing l WHERE l.hidden = false")
    List<Listing> getAllListings();

    @Query("SELECT l FROM Listing l WHERE l.id = ?1 AND l.hidden = false")
    Listing getListingByID(String id);

    @Transactional
    @Query(value = "INSERT INTO Listing (title, price, perks, address, description, application_link, date, thumbnail, gallery, hidden) VALUES " +
    "( " +
        ":#{#listing.title}, " +
        ":#{#listing.price}, " +
        ":#{#listing.perks}, " +
        ":#{#listing.address}, " +
        ":#{#listing.description}, " +
        ":#{#listing.application_link}, " +
        ":#{#listing.date}, " +
        ":#{#listing.thumbnail}, " +
        ":#{#listing.gallery}, " +
        ":#{#listing.hidden} " +
    ") RETURNING *", nativeQuery = true)
    public abstract Listing createListing(@Param("listing") Listing listing);

    @Transactional
    @Query(value = "UPDATE Listing SET " +
        "title = :#{#listing.title}, " +
        "price = :#{#listing.price}, " +
        "perks = :#{#listing.perks}, " +
        "address = :#{#listing.address}, " +
        "description = :#{#listing.description}, " +
        "application_link = :#{#listing.application_link}, " +
        "thumbnail = :#{#listing.thumbnail}, " +
        "gallery = :#{#listing.gallery} " +
        "WHERE id = :#{#listing.id} RETURNING *",
    nativeQuery = true)
    public abstract Listing updateListing(@Param("listing") Listing listing);

    @Transactional
    @Query(value = "UPDATE Listing SET hidden = true WHERE id = :#{#listing_id} RETURNING *", nativeQuery = true)
    public abstract Listing deleteListing(@Param("listing_id") int id);
}
