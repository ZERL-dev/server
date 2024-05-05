package ZERL.server.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import ZERL.server.models.Admin;
import ZERL.server.repositories.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin authenticateAdmin(Admin admin) {
        return adminRepository.authenticateAdmin(admin);
    }

    public Admin updateAdmin(Admin admin) {
        return adminRepository.updateAdmin(admin);
    }
}
