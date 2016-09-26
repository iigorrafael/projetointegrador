package br.com.projetointegrador.modelo.entidade;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

/**
 *
 * @author bruno
 */
@Entity
@Table(name = "tabela_participante")
public class ParticipanteEvento implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Evento evento;

    @ManyToOne
    private Papel papel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Papel getPapel() {
        return papel;
    }

    public void setPapel(Papel papel) {
        this.papel = papel;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.usuario);
        hash = 47 * hash + Objects.hashCode(this.evento);
        hash = 47 * hash + Objects.hashCode(this.papel);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ParticipanteEvento other = (ParticipanteEvento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.evento, other.evento)) {
            return false;
        }
        if (!Objects.equals(this.papel, other.papel)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ParticipanteEvento{" + "id=" + id + ", usuario=" + usuario + ", evento=" + evento + ", papel=" + papel + '}';
    }

    
}
