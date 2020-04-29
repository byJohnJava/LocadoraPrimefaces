package br.com.foursys.locadora.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.foursys.locadora.bean.Cidade;
import br.com.foursys.locadora.util.HibernateUtil;

public class CidadeDAO extends GenericDAO {

    @SuppressWarnings("unchecked")
    public ArrayList<Cidade> buscarTodos() throws Exception {

        ArrayList<Cidade> listaRetorno = new ArrayList<Cidade>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Cidade.class);
        criteria.addOrder(Order.asc("codigo"));
        listaRetorno = (ArrayList<Cidade>) criteria.list();
        sessao.close();
        return listaRetorno;
    }

    public ArrayList<Cidade> buscarNome(String nome) throws Exception {

        ArrayList<Cidade> listaRetorno = new ArrayList<Cidade>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Cidade.class);
        criteria.add(Restrictions.ilike("nome", nome + "%"));
        criteria.addOrder(Order.asc("nome"));
        listaRetorno = (ArrayList<Cidade>) criteria.list();
        sessao.close();
        return listaRetorno;
    }

    public Cidade buscarPorCodigo(int codigo) throws Exception {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Cidade cidade = (Cidade) sessao.get(Cidade.class, codigo);
        sessao.close();
        return cidade;
    }

}
