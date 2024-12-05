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
public class Asignacion {
    private int idAsignacion;
    private Usuarios usuario;
    private EstadoAtencion estadoAtencion;
    private TipoDocumento tipoDocumento;
    private Especialidad especialidad;
    private OffsetDateTime fechaHoraInicioAtencion;
    private OffsetDateTime fechaHoraFinAtencion;
    private String motivo;

    public Asignacion(int idAsignacion) {
        this.idAsignacion = idAsignacion;
    }
}
