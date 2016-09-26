/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetointegrador.modelo.entidade;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author bruno
 */
@Entity
@Table(name="tabela_evento")
public class Evento implements Serializable{
    
     private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name="nome_evento", nullable = false)
    private String nomeDoEvento;
    
    @Column(name="descricao_evento")
    private String descricaoEvento;
    
    @Column(name="vagas_evento")
    private int vagas;
    
    @Column(name="data_evento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data;
    
    @Column(name="requisitos_evento")
    private String requisitos;
    
    //Tentar implementar uma entidade para local
    @Column(name="local_evento", nullable = false)
    private String local;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDoEvento() {
        return nomeDoEvento;
    }

    public void setNomeDoEvento(String nomeDoEvento) {
        this.nomeDoEvento = nomeDoEvento;
    }

    public String getDescricaoEvento() {
        return descricaoEvento;
    }

    public void setDescricaoEvento(String descricaoEvento) {
        this.descricaoEvento = descricaoEvento;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    
      
}
