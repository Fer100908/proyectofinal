package com.mycompany.proyectofinal.beans;

import com.mycompany.proyectofinal.entidades.Asignacion;
import com.mycompany.proyectofinal.entidades.Especialidad;
import com.mycompany.proyectofinal.entidades.EstadoAtencion;
import com.mycompany.proyectofinal.entidades.TipoDocumento;
import com.mycompany.proyectofinal.entidades.Usuarios;
import com.mycompany.proyectofinal.services.AsignacionService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Named
@RequestScoped
public class AsignacionBean {
    private String txtIdDetalleTicket;
    private String txtIdUsuarioAtencion;
    private String txtIdEstadoAtencion;
    private String txtIdTipoEspecialidad;
    private String txtFechaHoraInicioAtencion;
    private String txtFechaHoraFinAtencion;
    private String txtDescripcionTicket;

    public String getTxtIdDetalleTicket() {
        return txtIdDetalleTicket;
    }

    public void setTxtIdDetalleTicket(String txtIdDetalleTicket) {
        this.txtIdDetalleTicket = txtIdDetalleTicket;
    }

    public String getTxtIdUsuarioAtencion() {
        return txtIdUsuarioAtencion;
    }

    public void setTxtIdUsuarioAtencion(String txtIdUsuarioAtencion) {
        this.txtIdUsuarioAtencion = txtIdUsuarioAtencion;
    }

    public String getTxtIdEstadoAtencion() {
        return txtIdEstadoAtencion;
    }

    public void setTxtIdEstadoAtencion(String txtIdEstadoAtencion) {
        this.txtIdEstadoAtencion = txtIdEstadoAtencion;
    }

    public String getTxtIdTipoEspecialidad() {
        return txtIdTipoEspecialidad;
    }

    public void setTxtIdTipoEspecialidad(String txtIdTipoEspecialidad) {
        this.txtIdTipoEspecialidad = txtIdTipoEspecialidad;
    }

    public String getTxtFechaHoraInicioAtencion() {
        return txtFechaHoraInicioAtencion;
    }

    public void setTxtFechaHoraInicioAtencion(String txtFechaHoraInicioAtencion) {
        this.txtFechaHoraInicioAtencion = txtFechaHoraInicioAtencion;
    }

    public String getTxtFechaHoraFinAtencion() {
        return txtFechaHoraFinAtencion;
    }

    public void setTxtFechaHoraFinAtencion(String txtFechaHoraFinAtencion) {
        this.txtFechaHoraFinAtencion = txtFechaHoraFinAtencion;
    }

    public String getTxtDescripcionTicket() {
        return txtDescripcionTicket;
    }

    public void setTxtDescripcionTicket(String txtDescripcionTicket) {
        this.txtDescripcionTicket = txtDescripcionTicket;
    } 
    
    public List<Asignacion> getLista() {
        AsignacionService asignacionService = new AsignacionService();
        return asignacionService.consultarAsignaciones();
    }
    
    public void guardar() {
        AsignacionService asignacionService = new AsignacionService();
        OffsetDateTime fechaHoraInicioAtencion = OffsetDateTime.parse(txtFechaHoraInicioAtencion);
        OffsetDateTime fechaHoraFinAtencion = OffsetDateTime.parse(txtFechaHoraFinAtencion);
        
        if(txtIdDetalleTicket.isEmpty())
            asignacionService.registrarAsignacion(new Asignacion(0,new Usuarios(),new EstadoAtencion(),new TipoDocumento(), new Especialidad(),fechaHoraInicioAtencion,fechaHoraFinAtencion,txtDescripcionTicket));
        else
            asignacionService.registrarAsignacion(new Asignacion(Integer.parseInt(txtIdDetalleTicket),new Usuarios(),new EstadoAtencion(),new TipoDocumento(), new Especialidad(),fechaHoraInicioAtencion,fechaHoraFinAtencion,txtDescripcionTicket));
        
        txtIdDetalleTicket = "";
        txtIdUsuarioAtencion = "";
        txtIdEstadoAtencion = "";
        txtIdTipoEspecialidad = "";
        txtFechaHoraInicioAtencion = "";
        txtFechaHoraFinAtencion = "";
        txtDescripcionTicket = "";        
    }
    
    public void editar(int idDetalleTicket, int idUsuarioAtencion, int idEstadoAtencion, int idTipoEspecialidad, OffsetDateTime fechaHoraInicioAtencion, OffsetDateTime fechaHoraFinAtencion, String descripcionTicket) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
        
        txtIdDetalleTicket = Integer.toString(idDetalleTicket);
        txtIdUsuarioAtencion = Integer.toString(idUsuarioAtencion);
        txtIdEstadoAtencion = Integer.toString(idEstadoAtencion);
        txtIdTipoEspecialidad = Integer.toString(idTipoEspecialidad);
        txtFechaHoraInicioAtencion = fechaHoraInicioAtencion.format(formatter);
        txtFechaHoraFinAtencion = fechaHoraFinAtencion.format(formatter);
        txtDescripcionTicket = descripcionTicket; 
    }
    
    public void eliminar(int id) {
        AsignacionService asignacionService = new AsignacionService();
        asignacionService.eliminarAsignacion(new Asignacion(id));
    }    
}
