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
@Table(name = "cliente")
public class Cliente implements Serializable {
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
    @Column(name = "cpf")
    private String cpf;
    @Basic(optional = false)
    @Column(name = "rg")
    private String rg;
    @Basic(optional = false)
    @Column(name = "data_nascimento")
    private String dataNascimento;
    @Basic(optional = false)
    @Column(name = "idade")
    private int idade;
    @Basic(optional = false)
    @Column(name = "sexo")
    private String sexo;
    @JoinColumn(name = "contato_codigo", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Contato contatoCodigo;
    @JoinColumn(name = "endereco_codigo", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Endereco enderecoCodigo;

    public Cliente() {
    }

    public Cliente(Integer codigo) {
        this.codigo = codigo;
    }

    public Cliente(Integer codigo, String nome, String cpf, String rg, String dataNascimento, int idade, String sexo) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
        this.sexo = sexo;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Contato getContatoCodigo() {
        return contatoCodigo;
    }

    public void setContatoCodigo(Contato contatoCodigo) {
        this.contatoCodigo = contatoCodigo;
    }

    public Endereco getEnderecoCodigo() {
        return enderecoCodigo;
    }

    public void setEnderecoCodigo(Endereco enderecoCodigo) {
        this.enderecoCodigo = enderecoCodigo;
    }
    
}
