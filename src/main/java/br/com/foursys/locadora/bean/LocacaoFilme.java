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
@Table(name = "locacao_filme")
public class LocacaoFilme implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @JoinColumn(name = "filme_codigo", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Filme filmeCodigo;
    @JoinColumn(name = "locacao_codigo", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Locacao locacaoCodigo;

    public LocacaoFilme() {
    }

    public LocacaoFilme(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Filme getFilmeCodigo() {
        return filmeCodigo;
    }

    public void setFilmeCodigo(Filme filmeCodigo) {
        this.filmeCodigo = filmeCodigo;
    }

    public Locacao getLocacaoCodigo() {
        return locacaoCodigo;
    }

    public void setLocacaoCodigo(Locacao locacaoCodigo) {
        this.locacaoCodigo = locacaoCodigo;
    }

}
