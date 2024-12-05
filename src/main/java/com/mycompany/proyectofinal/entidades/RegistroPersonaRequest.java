package com.mycompany.proyectofinal.entidades;

public class RegistroPersonaRequest {
    private Usuarios usuario;
    private int idRolUsuario;
    private int idTipoEspecialidad;
    private int idTipoDocumento;

    public RegistroPersonaRequest() {
    }

    public RegistroPersonaRequest(Usuarios usuario, int idRolUsuario, int idTipoEspecialidad, int idTipoDocumento) {
        this.usuario = usuario;
        this.idRolUsuario = idRolUsuario;
        this.idTipoEspecialidad = idTipoEspecialidad;
        this.idTipoDocumento = idTipoDocumento;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }    

    public int getIdRolUsuario() {
        return idRolUsuario;
    }

    public void setIdRolUsuario(int idRolUsuario) {
        this.idRolUsuario = idRolUsuario;
    }

    public int getIdTipoEspecialidad() {
        return idTipoEspecialidad;
    }

    public void setIdTipoEspecialidad(int idTipoEspecialidad) {
        this.idTipoEspecialidad = idTipoEspecialidad;
    }

    public int getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(int idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }
}
