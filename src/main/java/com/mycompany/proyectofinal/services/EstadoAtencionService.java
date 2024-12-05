package com.mycompany.proyectofinal.services;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import com.mycompany.proyectofinal.entidades.EstadoAtencion;

public class EstadoAtencionService {
    private static final String API_URL = "http://localhost:8086/estadoAtencion/";
    
    public List<EstadoAtencion> consultarEstadoAtencion() {
        Client client = ClientBuilder.newClient();
        List<EstadoAtencion> estadoAtenciones = client.target(API_URL + "listar")
                                .request(MediaType.APPLICATION_JSON)
                                .get(new GenericType<List<EstadoAtencion>>(){});
        client.close();
        return estadoAtenciones;
    }
    
    public Response registrarEstadoAtencion(EstadoAtencion estadoAtencion) {
        Client client = ClientBuilder.newClient();
        Response response = client.target(API_URL + "registrar")
                                .request(MediaType.APPLICATION_JSON)
                                .post(Entity.entity(estadoAtencion, MediaType.APPLICATION_JSON));
        client.close();
        return response;
    }
    
    public Response eliminarEstadoAtencion(EstadoAtencion estadoAtencion) {
        Client client = ClientBuilder.newClient();
        Response response = client.target(API_URL + "eliminar/" + estadoAtencion.getIdEstadoAtencion())
                                .request(MediaType.APPLICATION_JSON)
                                .delete();
        client.close();
        return response;
    }      
}
