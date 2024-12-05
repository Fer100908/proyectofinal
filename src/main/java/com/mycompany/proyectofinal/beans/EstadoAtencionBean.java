package com.mycompany.proyectofinal.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.List;
import com.mycompany.proyectofinal.entidades.EstadoAtencion;
import com.mycompany.proyectofinal.services.EstadoAtencionService;

@Named
@RequestScoped
public class EstadoAtencionBean {
    private String txtId;
    private String txtNombre;

    public String getTxtId() {
        return txtId;
    }

    public void setTxtId(String txtId) {
        this.txtId = txtId;
    }

    public String getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(String txtNombre) {
        this.txtNombre = txtNombre;
    }    
    
    public List<EstadoAtencion> getLista() {
        EstadoAtencionService estadoAtencionService = new EstadoAtencionService();
        return estadoAtencionService.consultarEstadoAtencion();
    }
    
    public void guardar() {
        EstadoAtencionService estadoAtencionService = new EstadoAtencionService();
        
        if(txtId.isEmpty())
            estadoAtencionService.registrarEstadoAtencion(new EstadoAtencion(0,txtNombre));
        else
            estadoAtencionService.registrarEstadoAtencion(new EstadoAtencion(Integer.parseInt(txtId),txtNombre));
        
        txtId = "";
        txtNombre = "";
    }
    
    public void editar(int id, String nombre) {
        txtId = Integer.toString(id);
        txtNombre = nombre;
    }
    
    public void eliminar(int id) {
        EstadoAtencionService estadoAtencionService = new EstadoAtencionService();
        estadoAtencionService.eliminarEstadoAtencion(new EstadoAtencion(id));
    }    
}
