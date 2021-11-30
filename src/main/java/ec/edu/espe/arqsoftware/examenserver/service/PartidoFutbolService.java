package ec.edu.espe.arqsoftware.examenserver.service;

import ec.edu.espe.arqsoftware.examenserver.dao.PartidoFutbolRepository;
import ec.edu.espe.arqsoftware.examenserver.ws.PartidoFutbol;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class PartidoFutbolService {
    @Autowired
    private final PartidoFutbolRepository repository;

    public PartidoFutbolService(PartidoFutbolRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public List<PartidoFutbol> obtenerPartidosPorFecha(){
        ZonedDateTime fechaActual = ZonedDateTime.now();
        LocalDateTime fechaOpt = fechaActual.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().atStartOfDay();
        log.info("Va a buscar partidos desde: {}", fechaOpt);
        List<PartidoFutbol> partidos = this.repository.findByFechaAfterOrFechaEquals(Timestamp.valueOf(fechaOpt));
        log.info("Los partidos a jugar son: {}", partidos);
        return partidos;
    }
}
