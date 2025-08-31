package com.xyz.auth.service;

import com.xyz.auth.dto.AuthRequest;
import com.xyz.auth.dto.AuthResponse;
import com.xyz.auth.dto.SignupRequest;
import com.xyz.auth.entity.Role;
import com.xyz.auth.entity.User;
import com.xyz.auth.repository.RoleRepository;
import com.xyz.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthResponse signup(SignupRequest request) {
        Set<Role> roles = new HashSet<>();
        request.getRoles().forEach(roleName -> 
            roleRepository.findByName(roleName)
                    .ifPresent(roles::add)
        );

        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(roles)
                .build();

        userRepository.save(user);
        String token = jwtService.generateToken(user.getUsername(), request.getRoles());
        return new AuthResponse(token);
    }

    public AuthResponse login(AuthRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        Set<String> roleNames = new HashSet<>();
        user.getRoles().forEach(r -> roleNames.add(r.getName()));

        String token = jwtService.generateToken(user.getUsername(), roleNames);
        return new AuthResponse(token);
    }
}
