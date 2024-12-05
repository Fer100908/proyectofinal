package com.mycompany.proyectofinal.services;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import com.mycompany.proyectofinal.entidades.Solicitud;

public class SolicitudService {
    private static final String API_URL = "http://localhost:8086/solicitud/";
    
    public List<Solicitud> consultarSolicitud() {
        Client client = ClientBuilder.newClient();
        List<Solicitud> tickets = client.target(API_URL + "listar")
                                .request(MediaType.APPLICATION_JSON)
                                .get(new GenericType<List<Solicitud>>(){});
        client.close();
        return tickets;
    }
    
    public Response registrarSolicitud(Solicitud solicitud) {
        Client client = ClientBuilder.newClient();
        Response response = client.target(API_URL + "registrar")
                                .request(MediaType.APPLICATION_JSON)
                                .post(Entity.entity(solicitud, MediaType.APPLICATION_JSON));
        client.close();
        return response;
    }
    
    public Response eliminarSolicitud(Solicitud solicitud) {
        Client client = ClientBuilder.newClient();
        Response response = client.target(API_URL + "eliminar/" + solicitud.getIdSolicitud())
                                .request(MediaType.APPLICATION_JSON)
                                .delete();
        client.close();
        return response;
    }        
}
