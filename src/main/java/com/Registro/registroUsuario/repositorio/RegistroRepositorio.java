package com.Registro.registroUsuario.repositorio;

import com.Registro.registroUsuario.entity.RegistroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroRepositorio extends JpaRepository<RegistroEntity,Integer> {
}
