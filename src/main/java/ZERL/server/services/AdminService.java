package ZERL.server.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.databind.ObjectMapper;
// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm; 
// import org.springframework.security.crypto.bcrypt.BCrypt;

import ZERL.server.models.Admin;
import ZERL.server.repositories.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Value("${security.jwt.secret}")
    private String secret;

    public Admin readJWT(String token) {

        ObjectMapper objectMapper = new ObjectMapper();
        // Claims parsedToken = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody(); 

        // return objectMapper.readValue(parsedToken, Admin);
        return new Admin();
    }

    public String createJWT(Admin admin) {
        // System.out.println(secret);
        // return Jwts.builder().signWith(SignatureAlgorithm.HS256, secret);
        return "token";
    }

    public boolean authenticateAdmin(Admin admin) {

        String existingAdminPassword = adminRepository.authenticateAdmin(admin.username);

        if (existingAdminPassword == null) {
            return false;
        }

        // if (BCrypt.checkpw(admin.password, existingAdminPassword)) {
        //     return true;
        // } else {
        //     return false;
        // }
        return true;
    }

    public Admin updatePassword(Admin admin) {

        // String encryptedPassword = BCrypt.hashpw(admin.password, BCrypt.gensalt());
        // admin.password = encryptedPassword;

        return adminRepository.updatePassword(admin);
    }
}
