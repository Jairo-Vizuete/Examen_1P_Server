package ec.edu.espe.arqsoftware.examenserver.model;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LocalidadPartidoId implements Serializable {

    @Column(name = "CODIGO", nullable = false)
    private Integer codigo;
    @Column(name = "CODIGO_LOCALIDAD", nullable = false, length = 30)
    private String codigoLocalidad;

    public String getCodigoLocalidad() {
        return codigoLocalidad;
    }

    public void setCodigoLocalidad(String codigoLocalidad) {
        this.codigoLocalidad = codigoLocalidad;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoLocalidad, codigo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        LocalidadPartidoId entity = (LocalidadPartidoId) o;
        return Objects.equals(this.codigoLocalidad, entity.codigoLocalidad) &&
                Objects.equals(this.codigo, entity.codigo);
    }
}