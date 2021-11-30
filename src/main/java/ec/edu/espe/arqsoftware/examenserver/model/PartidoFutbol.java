package ec.edu.espe.arqsoftware.examenserver.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "partido_futbol")
@Entity
@Data
public class PartidoFutbol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO", nullable = false)
    private Integer codigo;

    @Column(name = "EQUIPO_LOCAL", nullable = false, length = 50)
    private String equipoLocal;

    @Column(name = "EQUIPO_VISITA", nullable = false, length = 50)
    private String equipoVisita;

    @Column(name = "FECHA", nullable = false)
    private LocalDate fecha;

    @Column(name = "LUGAR", nullable = false, length = 100)
    private String lugar;

}