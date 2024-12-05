package com.mycompany.proyectofinal.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.List;
import com.mycompany.proyectofinal.entidades.Especialidad;
import com.mycompany.proyectofinal.services.EspecialidadService;

@Named
@RequestScoped
public class EspecialidadesBean {
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
    
    public List<Especialidad> getLista() {
        EspecialidadService rolUsuarioService = new EspecialidadService();
        return rolUsuarioService.consultarEspecialidades();
    }
    
    public void guardar() {
        EspecialidadService especialidadService = new EspecialidadService();
        
        if(txtId.isEmpty())
            especialidadService.registrarEspecialidad(new Especialidad(0,txtNombre));
        else
            especialidadService.registrarEspecialidad(new Especialidad(Integer.parseInt(txtId),txtNombre));
        
        txtId = "";
        txtNombre = "";
    }
    
    public void editar(int id, String nombre) {
        txtId = Integer.toString(id);
        txtNombre = nombre;
    }
    
    public void eliminar(int id) {
        EspecialidadService rolUsuarioService = new EspecialidadService();
        rolUsuarioService.eliminarEspecialidad(new Especialidad(id));
    }    
}
