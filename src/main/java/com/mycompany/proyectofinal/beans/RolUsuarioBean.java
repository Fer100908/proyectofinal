package com.mycompany.proyectofinal.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.List;
import com.mycompany.proyectofinal.entidades.RolUsuario;
import com.mycompany.proyectofinal.services.RolUsuarioService;

@Named
@RequestScoped
public class RolUsuarioBean {
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
    
    public List<RolUsuario> getLista() {
        RolUsuarioService rolUsuarioService = new RolUsuarioService();
        return rolUsuarioService.consultarRoles();
    }
    
    public void guardar() {
        RolUsuarioService rolUsuarioService = new RolUsuarioService();
        
        if(txtId.isEmpty())
            rolUsuarioService.registrarRol(new RolUsuario(0,txtNombre));
        else
            rolUsuarioService.registrarRol(new RolUsuario(Integer.parseInt(txtId),txtNombre));
        
        txtId = "";
        txtNombre = "";
    }
    
    public void editar(int id, String nombre) {
        txtId = Integer.toString(id);
        txtNombre = nombre;
    }
    
    public void eliminar(int id) {
        RolUsuarioService rolUsuarioService = new RolUsuarioService();
        rolUsuarioService.eliminarRol(new RolUsuario(id));
    }
}
