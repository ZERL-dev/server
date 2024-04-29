package ZERL.server.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ZERL.server.models.AdminModel;

@RestController
public class AdminController {

    @PostMapping("/admin/auth")
    public String authenticateAdmin(@RequestBody AdminModel admin) {
        return "true";
    }

    @PutMapping("/admin/update")
    public String updateAdmin(@RequestBody AdminModel admin) {
        return "true";
    }
}
