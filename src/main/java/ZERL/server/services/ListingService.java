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

    public Listing createListing(Listing listing) {
        return listingRepository.createListing(listing);
    }

    public Listing updateListing(Listing listing) {
        return listingRepository.updateListing(listing);
    }

    public Listing deleteListing(int id) {
        return listingRepository.deleteListing(id);
    }
}
