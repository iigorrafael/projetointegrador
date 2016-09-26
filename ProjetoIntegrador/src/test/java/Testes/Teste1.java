package Testes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.com.projetointegrador.modelo.dao.DAOGenerico;
import br.com.projetointegrador.modelo.entidade.Cidade;
import br.com.projetointegrador.modelo.entidade.Endereco;
import br.com.projetointegrador.modelo.entidade.Estado;
import br.com.projetointegrador.modelo.entidade.Evento;
import br.com.projetointegrador.modelo.entidade.Usuario;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aluno
 */
public class Teste1 {

    static Estado es = new Estado();
    static Cidade cid = new Cidade();
    static Evento evento = new Evento();
    static DAOGenerico dao = new DAOGenerico();

    public static void main(String[] args) {

        testeUsuario();
    }

    public static void testeUsuario() {
        Endereco end = new Endereco();
        Usuario user = new Usuario();
        Cidade cidade = new Cidade();
        
        cidade.setId(1L);
        
        List<Cidade> cidades = dao.listar(Cidade.class);

        for (Cidade cid : cidades) {
            if (Objects.equals(cid.getId(), cidade.getId())) {
                cidade = cid;
            }
        }
        

        end.setNumero("123");
        end.setBairro("teste");
        end.setCep("87720-260");
        end.setRua("teste");
        end.setCidade(cidade);

        user.setNome("teste");
        user.setRg("0.000.000-00");
        user.setCpf("000.000.000-00");
        user.setEmail("teste@teste");
        user.setTelefone("(00)0000-0000");
        user.setSenha("123");
        user.setEndereco(end);
        user.setEscolaridade("teste");
        user.setAtivo(true);

        dao.inserir(user);
    }

    public static void estadoTesteInserir() {
        es.setNome("Paraná");
        es.setSigla("PR");
        dao.inserir(es);
    }

    public static void cidadeTesteInserir() {

        List estados = dao.listar(Estado.class);
        Estado estado = new Estado();
        estado.setId(18L);

        cid.setNome("sumare");
        cid.setEstado(estado);
        dao.inserir(cid);
    }

    public static void usuarioTeste() {
        Usuario e = new Usuario();

        e.setNome("igor");
        e.setRg("1234567");
        e.setCpf("123456789");
        e.setTelefone("4488291744");
        e.setEmail("teste@teste.com");
        e.setSenha("123");
        e.setEscolaridade("Ensino Superior");
        dao.inserir(e);

//        dao.remover(Usuario.class, e.getId());
    }

    public static void estadoTeste() {
        List<Estado> estados = new ArrayList<>();
        List<Estado> lista = new ArrayList<>();
        estados = dao.listar(Estado.class);
        for (Estado e : estados) {
            if (e.getNome().toLowerCase().contains("pa")) {
                lista.add(e);
            }
        }
        for (Estado estado : lista) {
            System.out.println(estado.getNome());
        }
    }

    public static void cidadeTeste() {
        List<Cidade> cidades = new ArrayList<>();
        List<Cidade> lista = new ArrayList<>();
//        Long id = 1L;
//        cidades = dao.listar(Cidade.class);
//        for (Cidade c : cidades) {
//            if (c.getEstado().getId().equals(id)) {
//                lista.add(c);
//            }          
//
//        }
//        for (Cidade cidade : lista) {
//            System.out.println(cidade.getNome());
//        }

        es.setNome("Acre");
        es.setSigla("AC");
        es.setId(1L);

        cidades = dao.listar(Cidade.class, "estado =" + es.getId().toString());
        for (Cidade cidade : cidades) {
            System.out.println(cidade.getEstado().getNome());
            System.out.println(cidade.getNome());
        }
    }

    public static void eventoTeste() {
        evento.setNomeDoEvento("teste");
        evento.setVagas(10);
        evento.setLocal("teste");
        evento.setRequisitos("teste");
        evento.setData(Date.from(Instant.MIN));
        dao.inserir(evento);
    }

    public static void exibirObjetosColunas(Object obj) {
        List lista = new ArrayList();
        Field[] listaColunas;
//        Method[] listaGetters;
        listaColunas = obj.getClass().getDeclaredFields();
//        listaGetters = obj.getClass().getMethods();
        for (Field listaColuna : listaColunas) {
            lista.add(listaColuna.getName());
        }

        lista.remove(0);

        List listaObject = dao.listar(Estado.class);

        for (Object object : listaObject) {

            for (Object b : lista) {
                String s = b.toString();
                Object f;
                try {
                    try {
                        f = new PropertyDescriptor(s, object.getClass()).getReadMethod().invoke(object);
                        System.out.println(f.toString());
                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                        Logger.getLogger(Teste1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (IntrospectionException ex) {
                    Logger.getLogger(Teste1.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

}
