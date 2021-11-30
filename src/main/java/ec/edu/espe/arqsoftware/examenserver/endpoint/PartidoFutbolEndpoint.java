package ec.edu.espe.arqsoftware.examenserver.endpoint;

import ec.edu.espe.arqsoftware.examenserver.exception.CreateException;
import ec.edu.espe.arqsoftware.examenserver.ws.PartidoFutbol;
import ec.edu.espe.arqsoftware.examenserver.service.PartidoFutbolService;
import ec.edu.espe.arqsoftware.examenserver.ws.ObtenerPartidoFutbolPorFechaRequest;
import ec.edu.espe.arqsoftware.examenserver.ws.ObtenerPartidoFutbolPorFechaResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Endpoint
@Slf4j
public class PartidoFutbolEndpoint {

    private static final String NAMESPACE_URI = "http://espe.edu.ec/arqsoftware/ExamenServer/ws";

    private final PartidoFutbolService service;

    @Autowired

    public PartidoFutbolEndpoint (PartidoFutbolService service) {
        this.service = service;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "obtenerPartidoFutbolPorFechaRequest")
    @ResponsePayload
    public ObtenerPartidoFutbolPorFechaResponse obtenerPartidoFutbolPorFechaRequest(@RequestPayload ObtenerPartidoFutbolPorFechaRequest request) throws CreateException{

        List<PartidoFutbol> partidos = this.service.obtenerPartidosPorFecha();
        if (partidos.isEmpty()){
            log.error("Los partidos con la fecha {} no existen en la DB", request.getFecha());
            throw new CreateException("Message: "+"Los partidos con fecha "+request.getFecha()+" no existe en la base de datos");
        }
        List<PartidoFutbol> partidosOpt = new ArrayList<>();
        partidosOpt.forEach((i)->{
            partidosOpt.add(partidos);
        });
        ObtenerPartidoFutbolPorFechaResponse response = new ObtenerPartidoFutbolPorFechaResponse();
        return response.setPartidoFutbol(partidosOpt);
    }
}
