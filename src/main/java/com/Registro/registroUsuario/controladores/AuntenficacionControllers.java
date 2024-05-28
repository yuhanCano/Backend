package com.Registro.registroUsuario.controladores;

import com.Registro.registroUsuario.dto.ResponseDto;
import com.Registro.registroUsuario.dto.UsuarioLoginDto;
import com.Registro.registroUsuario.entity.RegistroEntity;
import com.Registro.registroUsuario.servicios.RegistroUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuntenficacionControllers {
    @Autowired
    private RegistroUsuario servicioRegistro;

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/login")
    public ResponseEntity<ResponseDto> loginUsuario(@RequestBody UsuarioLoginDto usuarioLoginDto) {
        ResponseDto responseDto = new ResponseDto();
        RegistroEntity usuario = servicioRegistro.autenticarUsuario(usuarioLoginDto);
        if (usuario != null) {
            responseDto.setStatus(200);
            responseDto.setMessage("Login exitoso");
            responseDto.setResult(usuario);
            return ResponseEntity.ok(responseDto);
        } else {
            responseDto.setStatus(401);
            responseDto.setMessage("Correo electrónico o contraseña inválidos");
            return ResponseEntity.status(401).body(responseDto);
        }
    }
}
