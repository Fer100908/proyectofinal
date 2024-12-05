package com.mycompany.proyectofinal.services;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import com.mycompany.proyectofinal.entidades.Asignacion;

public class AsignacionService {
    private static final String API_URL = "http://localhost:8086/asignacion/";
    
    public List<Asignacion> consultarAsignaciones() {
        Client client = ClientBuilder.newClient();
        List<Asignacion> asignaciones = client.target(API_URL + "listar")
                                .request(MediaType.APPLICATION_JSON)
                                .get(new GenericType<List<Asignacion>>(){});
        client.close();
        return asignaciones;
    }
    
    public Response registrarAsignacion(Asignacion asignacion) {
        Client client = ClientBuilder.newClient();
        Response response = client.target(API_URL + "registrar")
                                .request(MediaType.APPLICATION_JSON)
                                .post(Entity.entity(asignacion, MediaType.APPLICATION_JSON));
        client.close();
        return response;
    }
    
    public Response eliminarAsignacion(Asignacion asignacion) {
        Client client = ClientBuilder.newClient();
        Response response = client.target(API_URL + "eliminar/" + asignacion.getIdAsignacion())
                                .request(MediaType.APPLICATION_JSON)
                                .delete();
        client.close();
        return response;
    }   
    
}
