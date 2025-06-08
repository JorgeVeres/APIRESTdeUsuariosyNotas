package com.apiusuariosynotas.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.apiusuariosynotas.model.Usuario;
import com.apiusuariosynotas.service.UsuarioService;

@RestController
@RequestMapping("/api/v2/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioControllerV2 {
    
    private final UsuarioService usuarioService;
    
    @Autowired
    public UsuarioControllerV2(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    
    @PostMapping("/sign-in")
    @ResponseStatus(HttpStatus.OK)
    public SignInResponse signIn(@Valid @RequestBody SignInRequest request) {
        Usuario usuario = usuarioService.signIn(request.getEmail(), request.getPassword());
        return new SignInResponse("Login exitoso", usuario);
    }
    
    // ======================
    // DTOs (Data Transfer Objects)
    // ======================
    
    public static class SignInRequest {
        @NotBlank(message = "El email no puede estar vacío")
        @Email(message = "Debe ser un email válido")
        private String email;
        
        @NotBlank(message = "La contraseña no puede estar vacía")
        private String password;

        // Getters y Setters
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }
    
    public static class SignInResponse {
        private final String message;
        private final UsuarioData usuario;
        
        public SignInResponse(String message, Usuario usuario) {
            this.message = message;
            this.usuario = new UsuarioData(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getEmail()
            );
        }
        
        // Getters
        public String getMessage() { return message; }
        public UsuarioData getUsuario() { return usuario; }
    }
    
    public static class UsuarioData {
        private final Long id;
        private final String nombre;
        private final String email;
        
        public UsuarioData(Long id, String nombre, String email) {
            this.id = id;
            this.nombre = nombre;
            this.email = email;
        }
        
        // Getters
        public Long getId() { return id; }
        public String getNombre() { return nombre; }
        public String getEmail() { return email; }
    }
    
}