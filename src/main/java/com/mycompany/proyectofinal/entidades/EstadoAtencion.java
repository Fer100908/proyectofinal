package com.mycompany.proyectofinal.entidades;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstadoAtencion {    
    private int idEstadoAtencion;
    private String nombreEstadoTicket;

    public EstadoAtencion(int idEstadoAtencion) {
        this.idEstadoAtencion = idEstadoAtencion;
    }
}
