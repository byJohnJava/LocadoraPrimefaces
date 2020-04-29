package br.com.foursys.locadora.bean;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "filme")
public class Filme implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "valor")
    private Double valor;
    @Basic(optional = false)
    @Column(name = "disponivel")
    private String disponivel;
    @Basic(optional = false)
    @Column(name = "promocao")
    private String promocao;
    @Column(name = "valor_promocao")
    private Double valorPromocao;
    @JoinColumn(name = "genero_codigo", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Genero generoCodigo;

    public Filme() {
    }

    public Filme(Integer codigo) {
        this.codigo = codigo;
    }

    public Filme(Integer codigo, String nome, double valor, String disponivel, String promocao) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
        this.disponivel = disponivel;
        this.promocao = promocao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(String disponivel) {
        this.disponivel = disponivel;
    }

    public String getPromocao() {
        return promocao;
    }

    public void setPromocao(String promocao) {
        this.promocao = promocao;
    }

    public Double getValorPromocao() {
        return valorPromocao;
    }

    public void setValorPromocao(Double valorPromocao) {
        this.valorPromocao = valorPromocao;
    }

    public Genero getGeneroCodigo() {
        return generoCodigo;
    }

    public void setGeneroCodigo(Genero generoCodigo) {
        this.generoCodigo = generoCodigo;
    }

}
