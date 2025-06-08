package com.apiusuariosynotas.service;

import java.util.Optional;

import com.apiusuariosynotas.model.Usuario;

public interface UsuarioService extends CrudService<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
    boolean existsByEmail(String email);
    Usuario signIn(String email, String password);
}