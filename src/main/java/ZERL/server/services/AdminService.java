package ZERL.server.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.jose4j.jwt.JwtClaims;
import org.jose4j.jws.JsonWebSignature;
import java.security.Key;
import org.jose4j.keys.HmacKey;
import org.springframework.security.crypto.bcrypt.BCrypt;

import ZERL.server.repositories.AdminRepository;
import ZERL.server.models.Admin;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Value("${security.jwt.secret}")
    private String secret;

    public String createJWT(Admin admin) throws Exception {

        JwtClaims jwtClaims = new JwtClaims();
        JsonWebSignature jws = new JsonWebSignature();
        Key key = new HmacKey(secret.getBytes());

        jwtClaims.setClaim("username", admin.username);
        jwtClaims.setClaim("password", admin.password);

        jws.setKey(key);
        jws.setAlgorithmHeaderValue("HS256");
        jws.setPayload(jwtClaims.toJson());

        return jws.getCompactSerialization();
    }

    public boolean authenticateAdmin(Admin admin) {

        String existingAdminPassword = adminRepository.authenticateAdmin(admin.username);

        if (existingAdminPassword == null) {
            return false;
        }

        if (BCrypt.checkpw(admin.password, existingAdminPassword)) {
            return true;
        } else {
            return false;
        }
    }

    public Admin createAdmin(Admin admin) {

        String encryptedPassword = BCrypt.hashpw(admin.password, BCrypt.gensalt());
        admin.password = encryptedPassword;

        return adminRepository.createAdmin(admin);
    }

    public Admin updatePassword(Admin admin) {

        String encryptedPassword = BCrypt.hashpw(admin.password, BCrypt.gensalt());
        admin.password = encryptedPassword;

        return adminRepository.updatePassword(admin);
    }
}
