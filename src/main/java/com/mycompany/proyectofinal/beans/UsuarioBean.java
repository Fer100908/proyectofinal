package com.mycompany.proyectofinal.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.List;
import com.mycompany.proyectofinal.entidades.Usuarios;
import com.mycompany.proyectofinal.entidades.Asignacion;
import com.mycompany.proyectofinal.services.UsuariosService;
import java.util.ArrayList;

@Named
@RequestScoped
public class UsuarioBean {
    private String txtIdUsuario;
    private String txtIdPersona;
    private String txtIdRolUsuario;
    private String txtIdTipoEspecialidad;
    private String txtCorreo;
    private String txtContrasena;
    private String txtCambioContrasena;
    private String txtIdTipoDocumento;
    private String txtNroDocumento;
    private String txtNombres;
    private String txtApellidoPaterno;
    private String txtApellidoMaterno;

    public String getTxtIdUsuario() {
        return txtIdUsuario;
    }

    public void setTxtIdUsuario(String txtIdUsuario) {
        this.txtIdUsuario = txtIdUsuario;
    }

    public String getTxtIdPersona() {
        return txtIdPersona;
    }

    public void setTxtIdPersona(String txtIdPersona) {
        this.txtIdPersona = txtIdPersona;
    }

    public String getTxtIdRolUsuario() {
        return txtIdRolUsuario;
    }

    public void setTxtIdRolUsuario(String txtIdRolUsuario) {
        this.txtIdRolUsuario = txtIdRolUsuario;
    }

    public String getTxtIdTipoEspecialidad() {
        return txtIdTipoEspecialidad;
    }

    public void setTxtIdTipoEspecialidad(String txtIdTipoEspecialidad) {
        this.txtIdTipoEspecialidad = txtIdTipoEspecialidad;
    }

    public String getTxtCorreo() {
        return txtCorreo;
    }

    public void setTxtCorreo(String txtCorreo) {
        this.txtCorreo = txtCorreo;
    }

    public String getTxtContrasena() {
        return txtContrasena;
    }

    public void setTxtContrasena(String txtContrasena) {
        this.txtContrasena = txtContrasena;
    }

    public String getTxtCambioContrasena() {
        return txtCambioContrasena;
    }

    public void setTxtCambioContrasena(String txtCambioContrasena) {
        this.txtCambioContrasena = txtCambioContrasena;
    }

    public String getTxtIdTipoDocumento() {
        return txtIdTipoDocumento;
    }

    public void setTxtIdTipoDocumento(String txtIdTipoDocumento) {
        this.txtIdTipoDocumento = txtIdTipoDocumento;
    }

    public String getTxtNroDocumento() {
        return txtNroDocumento;
    }

    public void setTxtNroDocumento(String txtNroDocumento) {
        this.txtNroDocumento = txtNroDocumento;
    }

    public String getTxtNombres() {
        return txtNombres;
    }

    public void setTxtNombres(String txtNombres) {
        this.txtNombres = txtNombres;
    }

    public String getTxtApellidoPaterno() {
        return txtApellidoPaterno;
    }

    public void setTxtApellidoPaterno(String txtApellidoPaterno) {
        this.txtApellidoPaterno = txtApellidoPaterno;
    }

    public String getTxtApellidoMaterno() {
        return txtApellidoMaterno;
    }

    public void setTxtApellidoMaterno(String txtApellidoMaterno) {
        this.txtApellidoMaterno = txtApellidoMaterno;
    }
    
    public List<Usuarios> getLista() {
        UsuariosService usuariosService = new UsuariosService();
        return usuariosService.consultarUsuarios();
    }
    
    public void guardar() {
        
        UsuariosService usuariosService = new UsuariosService();

        Usuarios usuario = new Usuarios();
        usuario.setCorreo(txtCorreo);
        usuario.setContrasena("1234");
        usuario.setNroDocumento(txtNroDocumento);
        usuario.setNombres(txtNombres);
        usuario.setApellidoPaterno(txtApellidoPaterno);
        usuario.setApellidoMaterno(txtApellidoMaterno);
        usuario.setCambioContrasena(Boolean.TRUE);

        // Registrar Usuario y Persona a través del servicio
        usuariosService.registrarUsuario(usuario, Integer.parseInt(txtIdRolUsuario), Integer.parseInt(txtIdTipoEspecialidad), Integer.parseInt(txtIdTipoDocumento));

        // Limpiar campos después de registrar
        limpiarCampos();
    }

    // Método para limpiar los campos
    public void limpiarCampos() {
        txtIdPersona = "";
        txtIdTipoDocumento = "";
        txtNroDocumento = "";
        txtNombres = "";
        txtApellidoPaterno = "";
        txtApellidoMaterno = "";
        txtIdUsuario = "";
        txtIdRolUsuario = "";
        txtCorreo = "";
        txtContrasena = "";
    }
    
    public void editar(int idUsuario, int idPersona, int idRolUsuario, int idTipoEspecialidad, String correo, String contrasena, String cambioContrasena) {
        txtIdPersona = Integer.toString(idUsuario);
        txtIdPersona = Integer.toString(idPersona);
        txtIdRolUsuario = Integer.toString(idRolUsuario);
        txtIdTipoEspecialidad = Integer.toString(idTipoEspecialidad);
        txtCorreo = correo; 
        txtContrasena = contrasena; 
        txtCambioContrasena = cambioContrasena;  
    }
    
    public void eliminar(int id) {
        UsuariosService usuariosService = new UsuariosService();
        usuariosService.eliminarUsuarios(new Usuarios(id));
    }     
    
    /*private List<Asignacion> asignaciones = new ArrayList<>();

    public UsuarioBean() {
        // Inicializar con un formulario vacío para la primera asignación
        asignaciones.add(new Asignacion());
    }

    // Método para agregar una nueva asignación (nuevo formulario dinámico)
    public void agregarAsignacion() {
        asignaciones.add(new Asignacion());
    }

    // Método para guardar la solicitud con todas las asignaciones
    public void guardarSolicitud() {
        // Lógica para persistir las asignaciones y la solicitud
        System.out.println("Asignaciones guardadas: " + asignaciones.size());
    }

    // Getters y Setters
    public List<Asignacion> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(List<Asignacion> asignaciones) {
        this.asignaciones = asignaciones;
    }*/
}
