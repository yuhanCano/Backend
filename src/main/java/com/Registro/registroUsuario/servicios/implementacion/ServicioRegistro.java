package com.Registro.registroUsuario.servicios.implementacion;

import com.Registro.registroUsuario.dto.UsuarioDto;
import com.Registro.registroUsuario.dto.UsuarioLoginDto;
import com.Registro.registroUsuario.entity.RegistroEntity;
import com.Registro.registroUsuario.repositorio.RegistroRepositorio;
import com.Registro.registroUsuario.servicios.RegistroUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioRegistro implements RegistroUsuario {
    @Autowired
    private RegistroRepositorio repositorioUsuario;

    @Override
    public UsuarioDto guardarUsuario(UsuarioDto usuarioDto) {
        RegistroEntity usuarioEntity = RegistroEntity.builder()
                .idUser(usuarioDto.getIdUser())
                .name(usuarioDto.getName())
                .correoElectronico(usuarioDto.getCorreoElectronico())
                .contraseña(usuarioDto.getContraseña())
                .confirmarContraseña(usuarioDto.getConfirmarContraseña())
                .build();

        RegistroEntity guardar = repositorioUsuario.save(usuarioEntity);

        return UsuarioDto.builder()
                .idUser(guardar.getIdUser())
                .name(guardar.getName())
                .correoElectronico(guardar.getCorreoElectronico())
                .contraseña(guardar.getContraseña())
                .confirmarContraseña(guardar.getConfirmarContraseña())
                .build();
    }

    @Override
    public List<UsuarioDto> obtenerUsuario() {
        List<RegistroEntity> usuarioEntities = repositorioUsuario.findAll();
        return usuarioEntities.stream()
                .map(usuarioEntity -> UsuarioDto.builder()
                        .idUser(usuarioEntity.getIdUser())
                        .name(usuarioEntity.getName())
                        .correoElectronico(usuarioEntity.getCorreoElectronico())
                        .contraseña(usuarioEntity.getContraseña())
                        .confirmarContraseña(usuarioEntity.getConfirmarContraseña())
                        .build())
                .toList();
    }

    @Override
    public UsuarioDto obtenerUsuarioId(Integer id) {
        Optional<RegistroEntity> usuarioEntity = repositorioUsuario.findById(id);
        return UsuarioDto.builder()
                .idUser(usuarioEntity.get().getIdUser())
                .name(usuarioEntity.get().getName())
                .correoElectronico(usuarioEntity.get().getCorreoElectronico())
                .contraseña(usuarioEntity.get().getContraseña())
                .confirmarContraseña(usuarioEntity.get().getConfirmarContraseña())
                .build();
    }

    @Override
    public void eliminarUsuario(Integer id) {
        repositorioUsuario.deleteById(id);
    }

    @Override
    public RegistroEntity autenticarUsuario(UsuarioLoginDto usuarioLoginDto) {
        Optional<RegistroEntity> usuarioEntity = Optional.ofNullable(repositorioUsuario.findByCorreoElectronico(usuarioLoginDto.getCorreoElectronico()));
        if (usuarioEntity.isPresent() && usuarioEntity.get().getContraseña().equals(usuarioLoginDto.getContraseña())) {
            return usuarioEntity.get();
        }
        return null;
    }
}

