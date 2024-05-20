package com.Registro.registroUsuario.dto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {
    private int status;
    private String message;
    private Object result;

}
