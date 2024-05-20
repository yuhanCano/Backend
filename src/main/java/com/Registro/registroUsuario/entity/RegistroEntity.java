package com.Registro.registroUsuario.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "UsuarioRegistro")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistroEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user")
    private Integer idUser;
    @Column(name = "nombres")
    private String name;
    @Column(name = "Email")
    private String correoElectronico;
    @Column(name = "Contraseña")
    private String contraseña;
    @Column(name = "Confirmar contraseña")
    private String confirmarContraseña;
}
