package com.tms.security.service;

import com.tms.security.domain.SecurityCredentials;
import com.tms.security.repository.SecurityCredentialsRepository;
import com.tms.security.JwtUtils;
import com.tms.security.domain.AuthRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SecurityService {

    private final PasswordEncoder passwordEncoder;
    private final SecurityCredentialsRepository securityCredentialsRepository;
    private final JwtUtils jwtUtils;

    public SecurityService(PasswordEncoder passwordEncoder, SecurityCredentialsRepository securityCredentialsRepository, JwtUtils jwtUtils) {
        this.passwordEncoder = passwordEncoder;
        this.securityCredentialsRepository = securityCredentialsRepository;
        this.jwtUtils = jwtUtils;
    }

    public String generateToken(AuthRequest authRequest){
        Optional<SecurityCredentials> credentials = securityCredentialsRepository.findByUserLogin(authRequest.getLogin());
        if (credentials.isPresent() && passwordEncoder.matches(authRequest.getPassword(),credentials.get().getUserPassword())){
            return jwtUtils.generateJwtToken(authRequest.getLogin());
        }
        return "";
    }
}
