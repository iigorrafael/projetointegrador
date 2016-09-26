/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetointegrador.controle;

import br.com.projetointegrador.modelo.dao.DAOGenerico;
import br.com.projetointegrador.modelo.entidade.Evento;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;



/**
 *
 * @author igorr
 */
@ManagedBean(name = "controleEvento")
@RequestScoped
public class ControleEvento {

    DAOGenerico dao = new DAOGenerico();
    private Evento evento = new Evento();
    private List<Evento> eventos = new ArrayList();
;

    public void cadastrar() {

        dao.inserir(evento);
        
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage("Sucesso", "Cadastro efetuado"));
    }

    public Evento getEvento() {      
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public List<Evento> getEventos() {
        eventos = dao.listar(Evento.class);
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

}
