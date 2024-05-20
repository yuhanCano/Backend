package com.Registro.registroUsuario.controladores;

import com.Registro.registroUsuario.dto.ResponseDto;
import com.Registro.registroUsuario.dto.UsuarioDto;
import com.Registro.registroUsuario.servicios.RegistroUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registro")

public class  UsuarioControlador {
    @Autowired
    private RegistroUsuario servicioRegistro;
    @CrossOrigin(origins = "http://localhost:5173/Registro")
    @PostMapping("/guardar")
    public ResponseEntity<ResponseDto> guardarUsuario(@RequestBody UsuarioDto obj){
        ResponseDto responseDto = new ResponseDto();
        try{
            UsuarioDto usuarioDto = servicioRegistro.guardarUsuario(obj);
            responseDto.setStatus(201);
            responseDto.setMessage("Usuario creado exitosamente");
            responseDto.setResult(usuarioDto);
            return ResponseEntity.ok(responseDto);
        }catch (Exception e){
            responseDto.setStatus(500);
            responseDto.setMessage("Ocurrio un error en el serividor");
            return ResponseEntity.status(500).body(responseDto);
        }
    }
    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioDto>> obtenerUsuario(){
        return ResponseEntity.ok(servicioRegistro.obtenerUsuario());
    }
    @GetMapping("/listar/{id}")
    public ResponseEntity<ResponseDto> ObtenerUsuarioId(@PathVariable("id") Integer id){
        ResponseDto responseDto = new ResponseDto();
        try{
            UsuarioDto usuarioDto = servicioRegistro.obtenerUsuarioId(id);
            responseDto.setStatus(200);
            responseDto.setMessage("Recuperación del usuario exitosa");
            responseDto.setResult(usuarioDto);
            return ResponseEntity.ok(responseDto);
        }catch (Exception e){
            responseDto.setStatus(500);
            responseDto.setMessage("Ocurrio un error en el servidor");
            return ResponseEntity.status(500).body(responseDto);
        }
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<ResponseDto> deleteById(@PathVariable("id") Integer id){
        ResponseDto responseDTO = new ResponseDto();
        try{
            servicioRegistro.eliminarUsuario(id);
            responseDTO.setStatus(200);
            responseDTO.setMessage("Usuario eliminado exitosamente");
            return ResponseEntity.ok(responseDTO);
        }catch (Exception e){
            responseDTO.setStatus(500);
            responseDTO.setMessage("Ocurrio un error en el servidor");
            return ResponseEntity.status(500).body(responseDTO);
        }
    }

}
