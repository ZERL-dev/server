package ZERL.server.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import ZERL.server.models.Admin;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @PostMapping("/auth")
    public String authenticateAdmin(@RequestBody Admin admin) {
        return "true";
    }

    @PutMapping("/update")
    public String updateAdmin(@RequestBody Admin admin) {
        return "true";
    }
}
