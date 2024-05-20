package com.Registro.registroUsuario.dto;


import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {
    private Integer idUser;
    private String name;
    private String correoElectronico;
    private String contraseña;
    private String confirmarContraseña;
}
