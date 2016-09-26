/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetointegrador.modelo.entidade;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author bruno
 */
@Entity
@Table(name = "tabela_papel")
public class Papel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "papel")
    private String papel;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "papel_id", referencedColumnName = "id")
    private Set<ParticipanteEvento> participantes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    public Set<ParticipanteEvento> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(Set<ParticipanteEvento> participantes) {
        this.participantes = participantes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.papel);
        hash = 79 * hash + Objects.hashCode(this.participantes);
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
        final Papel other = (Papel) obj;
        if (!Objects.equals(this.papel, other.papel)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.participantes, other.participantes)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Papel{" + "id=" + id + ", papel=" + papel + ", participantes=" + participantes + '}';
    }

    
}
