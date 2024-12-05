package com.mycompany.proyectofinal.services;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import com.mycompany.proyectofinal.entidades.TipoDocumento;

public class TipoDocumentoService {    
    private static final String API_URL = "http://localhost:8086/tipoDocumento/";
    
    public List<TipoDocumento> consultarTipoDocumento() {
        Client client = ClientBuilder.newClient();
        List<TipoDocumento> tipoDocumentos = client.target(API_URL + "listar")
                                .request(MediaType.APPLICATION_JSON)
                                .get(new GenericType<List<TipoDocumento>>(){});
        client.close();
        return tipoDocumentos;
    }
    
    public Response registrarTipoDocumento(TipoDocumento tipoDocumentos) {
        Client client = ClientBuilder.newClient();
        Response response = client.target(API_URL + "registrar")
                                .request(MediaType.APPLICATION_JSON)
                                .post(Entity.entity(tipoDocumentos, MediaType.APPLICATION_JSON));
        client.close();
        return response;
    }
    
    public Response eliminarTipoDocumento(TipoDocumento tipoDocumentos) {
        Client client = ClientBuilder.newClient();
        Response response = client.target(API_URL + "eliminar/" + tipoDocumentos.getIdTipoDocumento())
                                .request(MediaType.APPLICATION_JSON)
                                .delete();
        client.close();
        return response;
    }  
}
