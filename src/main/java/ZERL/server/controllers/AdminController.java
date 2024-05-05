package ZERL.server.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ZERL.server.models.Admin;
import ZERL.server.services.AdminService;
import ZERL.server.controllers.CustomError;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/auth")
    public String authenticateAdmin(@RequestBody Admin admin) {
        return "true";
    }

    @PutMapping("/update")
    public String updateAdmin(@RequestBody Admin admin) {
        return "true";
    }
}
