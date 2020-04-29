package br.com.foursys.locadora.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.foursys.locadora.bean.Endereco;
import br.com.foursys.locadora.util.HibernateUtil;

public class EnderecoDAO extends GenericDAO {

    @SuppressWarnings("unchecked")
    public ArrayList<Endereco> buscarTodos() throws Exception {

        ArrayList<Endereco> listaRetorno = new ArrayList<Endereco>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Endereco.class);
        criteria.addOrder(Order.asc("codigo"));
        listaRetorno = (ArrayList<Endereco>) criteria.list();
        sessao.close();
        return listaRetorno;
    }

    public ArrayList<Endereco> buscarNome(String nome) throws Exception {

        ArrayList<Endereco> listaRetorno = new ArrayList<Endereco>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Endereco.class);
        criteria.add(Restrictions.ilike("nome", nome + "%"));
        criteria.addOrder(Order.asc("nome"));
        listaRetorno = (ArrayList<Endereco>) criteria.list();
        sessao.close();
        return listaRetorno;
    }

    public Endereco buscarPorCodigo(int codigo) throws Exception {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Endereco endereco = (Endereco) sessao.get(Endereco.class, codigo);
        sessao.close();
        return endereco;
    }

}
