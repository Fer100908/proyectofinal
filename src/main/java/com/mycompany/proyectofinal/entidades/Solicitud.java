package com.mycompany.proyectofinal.entidades;

import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solicitud {
    private int idSolicitud;
    private Usuarios usuarios;
    private EstadoAtencion estadoAtencion;
    private String nroSolicitud;
    private OffsetDateTime fechaHoraTicket;
    private String tiempoAtencionTicket;

    public Solicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }
}
