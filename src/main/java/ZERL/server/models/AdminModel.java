package ZERL.server.models;

public class AdminModel {

    public Integer id;
    public String username;
    public String password;
    
    public Boolean validate() {

        if (
            this.username != null || this.username != "" &&
            this.password != null || this.password != ""
        ) {
            return true;
        } else {
            return false;
        }
    }

}
