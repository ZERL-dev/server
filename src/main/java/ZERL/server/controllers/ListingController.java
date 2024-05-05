package ZERL.server.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import ZERL.server.models.Listing;
import ZERL.server.services.ListingService;
import ZERL.server.controllers.CustomError;

@RestController
@RequestMapping("/listing")
public class ListingController {

    @Autowired
    private ListingService listingService;

    private CustomError customError = new CustomError();

    @GetMapping("/all")
    public List<Listing> getAllListings() {
        try {
            return listingService.getAllListings();
        } catch (Exception error) {
            // return customError.serverError(req, error);
        }
        return null;
    }

    @GetMapping("/id/{id}")
    public Listing getListingByID(@RequestParam(value = "id") double id) {
        return null;
    }

    @PostMapping("/new")
    public void createListing(@RequestBody Listing listing) {
        listingService.createListing(listing);
    }

    @PutMapping("/update/{id}")
    public Listing updateListingByID(@RequestParam(value = "id") double id) {
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteListingByID(@RequestParam(value = "id") double id) {
    
    }
}
