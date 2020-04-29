package br.com.foursys.locadora.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.foursys.locadora.bean.LocacaoFilme;
import br.com.foursys.locadora.util.HibernateUtil;

public class LocacaoFilmeDAO extends GenericDAO {

    @SuppressWarnings("unchecked")
    public ArrayList<LocacaoFilme> buscarTodos() throws Exception {

        ArrayList<LocacaoFilme> listaRetorno = new ArrayList<LocacaoFilme>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(LocacaoFilme.class);
        criteria.addOrder(Order.asc("codigo"));
        listaRetorno = (ArrayList<LocacaoFilme>) criteria.list();
        sessao.close();
        return listaRetorno;
    }

    public ArrayList<LocacaoFilme> buscarNome(String nome) throws Exception {

        ArrayList<LocacaoFilme> listaRetorno = new ArrayList<LocacaoFilme>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(LocacaoFilme.class);
        criteria.add(Restrictions.ilike("nome", nome + "%"));
        criteria.addOrder(Order.asc("nome"));
        listaRetorno = (ArrayList<LocacaoFilme>) criteria.list();
        sessao.close();
        return listaRetorno;
    }

    public LocacaoFilme buscarPorCodigo(int codigo) throws Exception {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        LocacaoFilme locacaoFilme = (LocacaoFilme) sessao.get(LocacaoFilme.class, codigo);
        sessao.close();
        return locacaoFilme;
    }

}
