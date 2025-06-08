package com.apiusuariosynotas.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import com.apiusuariosynotas.model.Nota;

import java.util.List;

public interface NotaRepository extends JpaRepository<Nota, Long> {
    List<Nota> findByUsuarioId(Long usuarioId, Sort sort);
}