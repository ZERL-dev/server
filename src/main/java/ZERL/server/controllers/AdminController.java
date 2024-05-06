package ZERL.server.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import ZERL.server.services.AdminService;
import ZERL.server.models.Admin;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/auth")
    public Object authenticateAdmin(@RequestBody String jwt) {

        try {

            Admin admin = adminService.readJWT(jwt);
            boolean authenticatedAdmin = adminService.authenticateAdmin(admin);

            if (authenticatedAdmin == false) {
                return new ResponseEntity<String>("Invalid admin creds", HttpStatus.UNAUTHORIZED);
            }

            return new ResponseEntity<String>(adminService.createJWT(admin), HttpStatus.OK);

        } catch (Exception error) {
            return new ResponseEntity<Exception>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/update")
    public Object updatePassword(@RequestBody Admin admin) {

        try {

            if (admin.validate() == false) {
                return new ResponseEntity<String>("Invalid updated admin", HttpStatus.BAD_REQUEST);
            }

            boolean authenticatedAdmin = adminService.authenticateAdmin(admin);

            if (authenticatedAdmin == true) {
                return new ResponseEntity<String>("Invalid admin creds", HttpStatus.UNAUTHORIZED);
            }

            Admin updatedAdmin = adminService.updatePassword(admin);

            return new ResponseEntity<String>(adminService.createJWT(updatedAdmin), HttpStatus.OK);

        } catch (Exception error) {
            return new ResponseEntity<Exception>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
