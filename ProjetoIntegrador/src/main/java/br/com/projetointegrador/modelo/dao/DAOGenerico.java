/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetointegrador.modelo.dao;

import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Aluno
 */
public class DAOGenerico {

    private EntityManager em;

    public void inserir(Object obj) {
        em = CriarEntityManager.getInstancia().getEm();
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
    }

    public void alterar(Object obj) {
        em = CriarEntityManager.getInstancia().getEm();
        em.getTransaction().begin();
        em.merge(obj);
        em.flush();
        em.getTransaction().commit();
    }

    public void remover(Class classe, Long id) {
        em = CriarEntityManager.getInstancia().getEm();
        em.getTransaction().begin();

        Object obj = em.find(classe, id);
        if (obj != null) {
            em.remove(obj);
        }
        em.flush();

        em.getTransaction().commit();
    }

    public Object buscarPorId(Class classe, Long id) {
        em = CriarEntityManager.getInstancia().getEm();
        Object retorno = em.find(classe, id);
        return retorno;
    }

    public List listar(Class classe) {
        em = CriarEntityManager.getInstancia().getEm();
        List<Object> retorno = em.createQuery("from " + classe.getSimpleName()).getResultList();
        return retorno;
    }

    public List listar(Class classe, String condicao) {
        em = CriarEntityManager.getInstancia().getEm();
        List<Object> retorno = em.createQuery("from " + classe.getSimpleName() + " where " + condicao).getResultList();
        return retorno;
    }

}
