/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetointegrador.controle;

import br.com.projetointegrador.modelo.dao.DAOGenerico;
import br.com.projetointegrador.modelo.entidade.Cidade;
import br.com.projetointegrador.modelo.entidade.Endereco;
import br.com.projetointegrador.modelo.entidade.Estado;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import javax.faces.bean.ManagedBean;
import br.com.projetointegrador.modelo.entidade.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Admin
 */
@ManagedBean(name = "controleUsuario")
@RequestScoped
public class ControleUsuario {

    /**
     * Creates a new instance of ControleUsuario
     */
    Usuario usuario = new Usuario();
    DAOGenerico dao = new DAOGenerico();
    private Estado estado = new Estado();
    private Cidade cidade = new Cidade();
    private Endereco endereco = new Endereco();
    private List<Usuario> usuarios = new ArrayList();
    private List<Estado> estados = new ArrayList();
    private List<Cidade> cidades = new ArrayList();

    private String senha;

    public ControleUsuario() {

    }

    public void carregarCidades() {
        for (Estado est : estados) {
            if (Objects.equals(est.getId(), this.estado.getId())) {
                estado = est;
            }
        }
        getCidades();
    }

    public String cadastro() {
        for (Cidade cid : cidades) {
            if (Objects.equals(cid.getId(), cidade.getId())) {
                endereco.setCidade(cid);
            }
            System.out.println(cidade.getId().toString());
            System.out.println(endereco.getCidade().getId().toString());
        }

//        usuario.setNome(nome);
//        usuario.setCpf(cpf);
//        usuario.setEscolaridade(escolaridade);
//        usuario.setRg(rg);
//        usuario.setTelefone(telefone);
//        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setAtivo(true);
        usuario.setEndereco(endereco);

        dao.inserir(usuario);
        
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage("Sucesso", "Cadastro efetuado"));

        return "index";
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        this.senha = TransformaStringMD5.encrypt(senha);
    }

    public List<Estado> getEstados() {
        try {
            if ((estados == null) || (estados.isEmpty())) {
                estados = dao.listar(Estado.class);
            }
        } catch (Exception e) {

        }
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    public List<Cidade> getCidades() {
        try {
            if ((cidades == null) || (cidades.isEmpty())) {
                cidades = dao.listar(Cidade.class);
            } else {
                List<Cidade> listaCidadesEstado = new ArrayList();
                for (Cidade cid : cidades) {
                    if (Objects.equals(cid.getEstado().getId(), this.estado.getId())) {
                        listaCidadesEstado.add(cid);
                    }

                }
                cidades = listaCidadesEstado;
            }

        } catch (Exception e) {

        }
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Usuario> getUsuarios() {
        try {
            if ((usuarios == null) || (usuarios.isEmpty())) {
                usuarios = dao.listar(Usuario.class);
            }
        } catch (Exception e) {

        }
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

}
