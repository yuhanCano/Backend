package com.Registro.registroUsuario.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "UsuarioLogin")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String correoElectronico;
    private String contraseña;
}
