package ec.edu.espe.arqsoftware.examenserver.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Table(name = "localidad_partido")
@Entity
@Data
public class LocalidadPartido {
    @EmbeddedId
    private LocalidadPartidoId id;

    @Column(name = "DISPONIBILIDAD", nullable = false, precision = 10)
    private BigDecimal disponibilidad;

    @Column(name = "PRECIO", nullable = false, precision = 10, scale = 3)
    private BigDecimal precio;
}