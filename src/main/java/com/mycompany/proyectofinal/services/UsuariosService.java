package com.mycompany.proyectofinal.services;

import com.mycompany.proyectofinal.entidades.RegistroPersonaRequest;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import com.mycompany.proyectofinal.entidades.Usuarios;

public class UsuariosService {    
    private static final String API_URL = "http://localhost:8086/usuarios/";
    
    public List<Usuarios> consultarUsuarios() {
        Client client = ClientBuilder.newClient();
        List<Usuarios> usuarios = client.target(API_URL + "listar")
                                .request(MediaType.APPLICATION_JSON)
                                .get(new GenericType<List<Usuarios>>(){});
        client.close();
        return usuarios;
    }
    
    /*public Response registrarUsuarios(Usuarios usuario) {
        Client client = ClientBuilder.newClient();
        Response response = client.target(API_URL + "registrar")
                                .request(MediaType.APPLICATION_JSON)
                                .post(Entity.entity(usuario, MediaType.APPLICATION_JSON));
        client.close();
        return response;
    }*/
    
    public Response registrarUsuario(Usuarios usuarios, int idRolUsuario, int idTipoEspecialidad, int idTipoDocumento ) {
        Client client = ClientBuilder.newClient();

        // Crear el objeto combinado para enviar al backend
        RegistroPersonaRequest registroRequest = new RegistroPersonaRequest();
        registroRequest.setUsuario(usuarios);
        registroRequest.setIdRolUsuario(idRolUsuario);
        registroRequest.setIdTipoEspecialidad(idTipoEspecialidad);
        registroRequest.setIdTipoDocumento(idTipoDocumento);

        // Enviar la solicitud al endpoint combinado
        Response response = client.target(API_URL + "registrar")
                                .request(MediaType.APPLICATION_JSON)
                                .post(Entity.entity(registroRequest, MediaType.APPLICATION_JSON));
        client.close();
        return response;
    }
    
    public Response eliminarUsuarios(Usuarios usuario) {
        Client client = ClientBuilder.newClient();
        Response response = client.target(API_URL + "eliminar/" + usuario.getIdUsuario())
                                .request(MediaType.APPLICATION_JSON)
                                .delete();
        client.close();
        return response;
    }   
}
