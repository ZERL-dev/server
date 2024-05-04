package ZERL.server.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import ZERL.server.models.Listing;
import ZERL.server.repositories.ListingRepository;

@Service
public class ListingService {

    @Autowired
    private ListingRepository listingRepository;

    public List<Listing> getAllListings() {
        return listingRepository.getAllListings();
    }

    public Listing getListingByID(String id) {
        return listingRepository.getListingByID(id);
    }

    public void createListing(Listing listing) {
        listingRepository.createListing(listing);
    }

    public void updateListing(Listing listing) {
        listingRepository.updateListing(listing);
    }

    public void deleteListing(double id) {
        listingRepository.deleteListing(id);
    }
}
