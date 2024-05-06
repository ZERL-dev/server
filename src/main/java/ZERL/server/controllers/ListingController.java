package ZERL.server.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

import ZERL.server.services.ListingService;
import ZERL.server.models.Listing;

@RestController
@RequestMapping("/listing")
public class ListingController {

    @Autowired
    private ListingService listingService;

    @GetMapping("/all")
    public Object getAllListings() {

        try {

            List<Listing> allListings = listingService.getAllListings();

            if (allListings == null) {
                return new ResponseEntity<String>("No listings found", HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<List<Listing>>(allListings, HttpStatus.OK);

        } catch (Exception error) {
            return new ResponseEntity<Exception>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/id/{id}")
    public Object getListingByID(@PathVariable String id) {

        try {

            Listing listingByID = listingService.getListingByID(id);

            if (listingByID == null) {
                return new ResponseEntity<String>("Listing with this id not found", HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<Listing>(listingByID, HttpStatus.OK);

        } catch (Exception error) {
            return new ResponseEntity<Exception>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/new")
    public Object createListing(@RequestBody Listing listing) {

        try {

            if (listing.validate() == false) {
                return new ResponseEntity<String>("Invalid listing", HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<Listing>(listingService.createListing(listing), HttpStatus.OK);

        } catch (Exception error) {
            return new ResponseEntity<Exception>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public Object updateListing(@RequestBody Listing listing) {

        try {

            if (listing.validate() == false) {
                return new ResponseEntity<String>("Invalid listing", HttpStatus.BAD_REQUEST);
            }

            Listing updatedListing = listingService.updateListing(listing);

            if (updatedListing == null) {
                return new ResponseEntity<String>("Listing with this id not found", HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<Listing>(updatedListing, HttpStatus.OK);

        } catch (Exception error) {
            return new ResponseEntity<Exception>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public Object deleteListing(@PathVariable int id) {

        try {

            Listing deletedListing = listingService.deleteListing(id);

            if (deletedListing == null) {
                return new ResponseEntity<String>("Listing with this id not found", HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<Listing>(deletedListing, HttpStatus.OK);

        } catch (Exception error) {
            return new ResponseEntity<Exception>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
