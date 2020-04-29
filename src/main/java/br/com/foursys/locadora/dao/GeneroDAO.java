package br.com.foursys.locadora.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import br.com.foursys.locadora.bean.Genero;
import br.com.foursys.locadora.util.HibernateUtil;

public class GeneroDAO extends GenericDAO {

    @SuppressWarnings("unchecked")
    public ArrayList<Genero> buscarTodos() throws Exception {

        ArrayList<Genero> listaRetorno = new ArrayList<Genero>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Genero.class);
        criteria.addOrder(Order.asc("codigo"));
        listaRetorno = (ArrayList<Genero>) criteria.list();
        sessao.close();
        return listaRetorno;
    }

}
