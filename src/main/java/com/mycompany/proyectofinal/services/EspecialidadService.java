package com.mycompany.proyectofinal.services;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import com.mycompany.proyectofinal.entidades.Especialidad;

public class EspecialidadService {
    private static final String API_URL = "http://localhost:8086/especialidad/";
    
    public List<Especialidad> consultarEspecialidades() {
        Client client = ClientBuilder.newClient();
        List<Especialidad> especialidades = client.target(API_URL + "listar")
                                .request(MediaType.APPLICATION_JSON)
                                .get(new GenericType<List<Especialidad>>(){});
        client.close();
        return especialidades;
    }
    
    public Response registrarEspecialidad(Especialidad especialidad) {
        Client client = ClientBuilder.newClient();
        Response response = client.target(API_URL + "registrar")
                                .request(MediaType.APPLICATION_JSON)
                                .post(Entity.entity(especialidad, MediaType.APPLICATION_JSON));
        client.close();
        return response;
    }
    
    public Response eliminarEspecialidad(Especialidad especialidad) {
        Client client = ClientBuilder.newClient();
        Response response = client.target(API_URL + "eliminar/" + especialidad.getIdEspecialidad())
                                .request(MediaType.APPLICATION_JSON)
                                .delete();
        client.close();
        return response;
    }
}
