package com.teacompanion.TEACompanion_API.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teacompanion.TEACompanion_API.DTO.Usuario.LoginDTO;
import com.teacompanion.TEACompanion_API.DTO.Usuario.LoginResponseDTO;
import com.teacompanion.TEACompanion_API.Model.Usuario;
import com.teacompanion.TEACompanion_API.Service.Auth.TokenService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginDTO dto) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword());

        var authentication = authManager.authenticate(authenticationToken);

        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        LoginResponseDTO responseDTO = new LoginResponseDTO();

        responseDTO.setEmail(dto.getEmail());
        responseDTO.setToken(tokenJWT);

        return ResponseEntity.ok(responseDTO);
    }
}
