package com.mycompany.proyectofinal.services;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import com.mycompany.proyectofinal.entidades.RolUsuario;

public class RolUsuarioService {
    private static final String API_URL = "http://localhost:8086/rolUsuario/";
    
    public List<RolUsuario> consultarRoles() {
        Client client = ClientBuilder.newClient();
        List<RolUsuario> roles = client.target(API_URL + "listar")
                                .request(MediaType.APPLICATION_JSON)
                                .get(new GenericType<List<RolUsuario>>(){});
        client.close();
        return roles;
    }
    
    public Response registrarRol(RolUsuario rol) {
        Client client = ClientBuilder.newClient();
        Response response = client.target(API_URL + "registrar")
                                .request(MediaType.APPLICATION_JSON)
                                .post(Entity.entity(rol, MediaType.APPLICATION_JSON));
        client.close();
        return response;
    }
    
    public Response eliminarRol(RolUsuario rol) {
        Client client = ClientBuilder.newClient();
        Response response = client.target(API_URL + "eliminar/" + rol.getIdRol())
                                .request(MediaType.APPLICATION_JSON)
                                .delete();
        client.close();
        return response;
    }    
}
