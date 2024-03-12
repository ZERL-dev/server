package ZERL.server.routes;

import java.util.Map;

public class listing {
    
    Map<String, String> routes = Map.of(
        "getAllListings", "/listings",
        "getListingByID", "/listings/id/{id}",
        "createListing", "/listings/new",
        "updateListing", "/listings/update/{id}",
        "deleteListing", "/listings/delete/{id}"
    );

}
