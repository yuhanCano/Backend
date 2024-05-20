package com.Registro.registroUsuario.servicios;

import com.Registro.registroUsuario.dto.UsuarioDto;

import java.util.List;

public interface RegistroUsuario {
    UsuarioDto guardarUsuario(UsuarioDto usuarioDto);
    List<UsuarioDto> obtenerUsuario();

    UsuarioDto obtenerUsuarioId(Integer id);
    void eliminarUsuario(Integer id);
}
