package com.Registro.registroUsuario.dto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioLoginDto {
    private String correoElectronico;
    private String contraseña;
}
