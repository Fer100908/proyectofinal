package com.mycompany.proyectofinal.entidades;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuarios {
    private int idUsuario;
    private TipoDocumento tipoDocumento;
    private RolUsuario rolUsuario;
    private Especialidad tipoEspecialidad;
    private String nroDocumento;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correo;
    private String contrasena;
    private Boolean cambioContrasena;

    public Usuarios(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
