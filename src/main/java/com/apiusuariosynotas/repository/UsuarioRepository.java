package com.apiusuariosynotas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiusuariosynotas.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
    boolean existsByEmail(String email);
}