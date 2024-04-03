package ZERL.server.models;

public class ListingModel {

    public Integer id;
    public String title;
    public Integer price;
    public String perks;
    public String address;
    public String description;
    public String application_link;
    public String thumbnail;
    public String[] gallery;

    public Boolean validate() {

        if (
            this.title != null || this.title != "" &&
            this.price != null || this.price != 0 &&
            this.address != null || this.address != "" &&
            this.thumbnail != null || this.thumbnail != ""
        ) {
            return true;
        } else {
            return false;
        }
    }

}
