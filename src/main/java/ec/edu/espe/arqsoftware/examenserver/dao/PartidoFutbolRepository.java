package ec.edu.espe.arqsoftware.examenserver.dao;

import ec.edu.espe.arqsoftware.examenserver.ws.PartidoFutbol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PartidoFutbolRepository extends JpaRepository<PartidoFutbol, Integer> {

    List<PartidoFutbol> findByFechaAfterOrFechaEquals(Date fechaActual);

}
