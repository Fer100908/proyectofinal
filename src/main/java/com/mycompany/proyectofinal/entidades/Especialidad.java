package com.mycompany.proyectofinal.entidades;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Especialidad {
    private int idEspecialidad;
    private String nombreEspecialidad;    

    public Especialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }
}
