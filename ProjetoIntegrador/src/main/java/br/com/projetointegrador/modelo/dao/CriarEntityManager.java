
package br.com.projetointegrador.modelo.dao;

import javax.persistence.*;


public class CriarEntityManager {
    //Padrão Singleton: garante uma única instancia da classe
    private static CriarEntityManager criarem;
    private EntityManager em;
    
    public CriarEntityManager(){
      em=Persistence.createEntityManagerFactory("ProjetoIntegradorPU").createEntityManager();
    }
    
    public static CriarEntityManager getInstancia(){
      if(criarem==null){
           criarem=new CriarEntityManager(); 
    }
    return criarem;
}
     public EntityManager getEm(){
        return em;
     }
     
     
}
