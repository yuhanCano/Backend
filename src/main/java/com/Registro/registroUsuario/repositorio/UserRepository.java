package com.Registro.registroUsuario.repositorio;

import com.Registro.registroUsuario.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByCorreoElectronico(String correoElectronico);
}
