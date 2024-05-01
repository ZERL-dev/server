package ZERL.server.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import ZERL.server.models.ListingModel;

@RestController
@RequestMapping("/listing")
public class ListingController {

    @GetMapping("/all")
    public ListingModel[] getAllListings() {

        return null;
    }

    @GetMapping("/id/{id}")
    public ListingModel getListingByID(@RequestParam(value = "id") double id) {
        return null;
    }

    @PostMapping("/new")
    public void createListing(@RequestBody ListingModel listing) {
    
    }

    @PutMapping("/update/{id}")
    public ListingModel updateListingByID(@RequestParam(value = "id") double id) {
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteListingByID(@RequestParam(value = "id") double id) {
    
    }

}
