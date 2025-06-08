package com.apiusuariosynotas.model;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Entity
@Table(name = "usuarios")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    @Column(name = "nombre_completo", nullable = false)  // Mejor nombre de columna
    private String nombre;
    
    @NotBlank(message = "El email no puede estar vacío")
    @Email(message = "Debe ser un email válido")
    @Column(nullable = false, updatable = false)  // Email no modificable
    private String email;
    
    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    @Column(nullable = false, name = "password_hash")
    private String passwordHash;
    
    @OneToMany(
        mappedBy = "usuario",
        cascade = CascadeType.ALL,
        orphanRemoval = true,
        fetch = FetchType.LAZY
    )
    @JsonManagedReference
    private List<Nota> notas = new ArrayList<>();

    // Constructores
    protected Usuario() {}  
    
    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
    
    public List<Nota> getNotas() { return notas; }
    public void setNotas(List<Nota> notas) { this.notas = notas; }
    // Métodos de dominio
    public void agregarNota(Nota nota) {
        notas.add(nota);
        nota.setUsuario(this);
    }
    
    public void removerNota(Nota nota) {
        notas.remove(nota);
        nota.setUsuario(null);
    }
    
    // Equals y HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        return id != null && id.equals(((Usuario) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}