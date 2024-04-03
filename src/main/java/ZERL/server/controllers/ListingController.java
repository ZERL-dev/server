package ZERL.server.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

import ZERL.server.models.ListingModel;

@RestController
public class ListingController {

    @GetMapping("/listings")
    public ListingModel[] getAllListings() {

        return null;
    }

    @GetMapping("/listings/id/{id}")
    public ListingModel getListingByID(@RequestParam(value = "id") int id) {
        return null;
    }

    @PostMapping("/listings/new")
    public void createListing(@RequestBody ListingModel listing) {
    
    }

    @PutMapping("/listings/update/{id}")
    public ListingModel updateListingByID(@RequestParam(value = "id") int id) {
        return null;
    }

    @DeleteMapping("/listings/delete/{id}")
    public void deleteListingByID(@RequestParam(value = "id") int id) {
    
    }

}
