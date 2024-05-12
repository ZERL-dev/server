package ZERL.server.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
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
    public Object authenticateAdmin(@RequestBody Admin admin) {

        try {

            if (admin.validate() == false) {
                return new ResponseEntity<String>("Invalid body", HttpStatus.BAD_REQUEST);
            }

            boolean authenticatedAdmin = adminService.authenticateAdmin(admin);

            if (authenticatedAdmin == false) {
                return new ResponseEntity<String>("Invalid admin creds", HttpStatus.UNAUTHORIZED);
            }

            return new ResponseEntity<String>(adminService.createJWT(admin), HttpStatus.OK);

        } catch (Exception error) {
            return new ResponseEntity<Exception>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create")
    public Object createAdmin(@RequestBody Admin admin) {

        try {

            if (admin.validate() == false) {
                return new ResponseEntity<String>("Invalid body", HttpStatus.BAD_REQUEST);
            }

            Admin createdAdmin = adminService.createAdmin(admin);

            return new ResponseEntity<String>(adminService.createJWT(createdAdmin), HttpStatus.CREATED);

        } catch (Exception error) {
            return new ResponseEntity<Exception>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/update/{updatedPassword}")
    public Object updatePassword(@RequestBody Admin admin, @PathVariable String updatedPassword) {

        try {

            if (admin.validate() == false) {
                return new ResponseEntity<String>("Invalid body", HttpStatus.BAD_REQUEST);
            }

            boolean authenticatedAdmin = adminService.authenticateAdmin(admin);

            if (authenticatedAdmin == false) {
                return new ResponseEntity<String>("Invalid admin creds", HttpStatus.UNAUTHORIZED);
            }

            admin.password = updatedPassword;

            Admin updatedAdmin = adminService.updatePassword(admin);

            return new ResponseEntity<String>(adminService.createJWT(updatedAdmin), HttpStatus.OK);

        } catch (Exception error) {
            return new ResponseEntity<Exception>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
