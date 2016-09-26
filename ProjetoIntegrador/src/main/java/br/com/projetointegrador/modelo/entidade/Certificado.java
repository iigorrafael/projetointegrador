package br.com.projetointegrador.modelo.entidade;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tabela_certificado")
public class Certificado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "descricao_certificado", length = 250, nullable = false)
    private String descricao;

    @Column(name = "verificacao_certificado", length = 250, nullable = false)
    private String verificacao;

    @OneToOne(cascade = CascadeType.ALL)
    private Evento evento;

    //Duvida se devo colocar um os dados do usuario para preencher os vazios do certificado
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getVerificacao() {
        return verificacao;
    }

    public void setVerificacao(String verificacao) {
        this.verificacao = verificacao;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.id);
        hash = 11 * hash + Objects.hashCode(this.descricao);
        hash = 11 * hash + Objects.hashCode(this.verificacao);
        hash = 11 * hash + Objects.hashCode(this.evento);
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
        final Certificado other = (Certificado) obj;
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.verificacao, other.verificacao)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.evento, other.evento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Certificado{" + "id=" + id + ", descricao=" + descricao + ", verificacao=" + verificacao + ", evento=" + evento + '}';
    }

    
}
