/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetointegrador.modelo.entidade;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author bruno
 */
@Entity
@Table(name = "tabela_trabalho")
public class TrabalhoSeminarista implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "titulo_trabalho")
    private String titulo;

    @Column(name = "tema_trabalho")
    private String tema;

    @Column(name = "descricao_trabalho")
    private String descricao;

    @Column(name = "autores_trabalho")
    private String autores;

//    @Column(name="Trabalho_Trabalho")
//    private Byte trabalho;
//    @OneToMany
//    private Avaliador avaliador;
    @ManyToOne
    @JoinColumn(name = "participante_id")
    private ParticipanteEvento participante;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public ParticipanteEvento getParticipante() {
        return participante;
    }

    public void setParticipante(ParticipanteEvento participante) {
        this.participante = participante;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.titulo);
        hash = 23 * hash + Objects.hashCode(this.tema);
        hash = 23 * hash + Objects.hashCode(this.descricao);
        hash = 23 * hash + Objects.hashCode(this.autores);
        hash = 23 * hash + Objects.hashCode(this.participante);
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
        final TrabalhoSeminarista other = (TrabalhoSeminarista) obj;
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.tema, other.tema)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.autores, other.autores)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.participante, other.participante)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TrabalhoSeminarista{" + "id=" + id + ", titulo=" + titulo + ", tema=" + tema + ", descricao=" + descricao + ", autores=" + autores + ", participante=" + participante + '}';
    }

    
}
