package com.apiusuariosynotas.service;

import org.springframework.data.domain.Sort;
import com.apiusuariosynotas.model.Nota;

import java.util.List;

public interface NotaService extends CrudService<Nota, Long> {
    List<Nota> getNotasByUsuarioId(Long usuarioId, Sort sort);
    Nota createNotaForUsuario(Long usuarioId, Nota nota);
}
