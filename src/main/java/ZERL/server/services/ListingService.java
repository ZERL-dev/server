// package ZERL.server.services;

// import org.springframework.stereotype.Service;
// import org.springframework.beans.factory.annotation.Autowired;

// import ZERL.server.models.ListingModel;
// import ZERL.server.repositories.ListingRepository;

// @Service
// public class ListingService {

//     @Autowired
//     private ListingRepository listingRepository;

//     public ListingModel[] getAllListings() {
//         return listingRepository.getAllListings();
//     }

//     public ListingModel getListingByID(String id) {
//         return listingRepository.getListingByID(id);
//     }

//     public void createListing(double id, String title, double price, String perks, String address, String description, String application_link, String thumbnail, String[] gallery) {
//         listingRepository.createListing(id, title, price, perks, address, description, application_link, thumbnail, gallery);
//     }

//     public void updateListing(String title, double price, String perks, String address, String description, String application_link, String thumbnail, String[] gallery, double id) {
//         listingRepository.updateListing(title, price, perks, address, description, application_link, thumbnail, gallery, id);
//     }

//     public void deleteListing(double id) {
//         listingRepository.deleteListing(id);
//     }
// }
