package com.mycompany.proyectofinal.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.List;
import com.mycompany.proyectofinal.entidades.TipoDocumento;
import com.mycompany.proyectofinal.services.TipoDocumentoService;

@Named
@RequestScoped
public class TipoDocumentoBean {
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
    
    public List<TipoDocumento> getLista() {
        TipoDocumentoService tipoDocumentoService = new TipoDocumentoService();
        return tipoDocumentoService.consultarTipoDocumento();
    }
    
    public void guardar() {
        TipoDocumentoService rolUsuarioService = new TipoDocumentoService();
        
        if(txtId.isEmpty())
            rolUsuarioService.registrarTipoDocumento(new TipoDocumento(0,txtNombre));
        else
            rolUsuarioService.registrarTipoDocumento(new TipoDocumento(Integer.parseInt(txtId),txtNombre));
        
        txtId = "";
        txtNombre = "";
    }
    
    public void editar(int idTipoDocumento, String nombreTipoDocumento) {
        txtId = Integer.toString(idTipoDocumento);
        txtNombre = nombreTipoDocumento;
    }
    
    public void eliminar(int id) {
        TipoDocumentoService tipoDocumentoService = new TipoDocumentoService();
        tipoDocumentoService.eliminarTipoDocumento(new TipoDocumento(id));
    }    
}
