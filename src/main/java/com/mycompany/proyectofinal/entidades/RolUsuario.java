package com.mycompany.proyectofinal.entidades;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolUsuario {
    private int idRol;
    private String nombreRolUsuario;

    public RolUsuario(int idRol) {
        this.idRol = idRol;
    }
}
