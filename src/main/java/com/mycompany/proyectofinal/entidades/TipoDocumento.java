package com.mycompany.proyectofinal.entidades;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoDocumento {
    private int idTipoDocumento;
    private String nombreTipoDocumento;

    public TipoDocumento(int idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }
}
