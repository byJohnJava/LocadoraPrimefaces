package br.com.foursys.locadora.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.foursys.locadora.bean.Funcionario;
import br.com.foursys.locadora.util.HibernateUtil;

public class FuncionarioDAO extends GenericDAO {

    @SuppressWarnings("unchecked")
    public ArrayList<Funcionario> buscarTodos() throws Exception {

        ArrayList<Funcionario> listaRetorno = new ArrayList<Funcionario>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Funcionario.class);
        criteria.addOrder(Order.asc("codigo"));
        listaRetorno = (ArrayList<Funcionario>) criteria.list();
        sessao.close();
        return listaRetorno;
    }

    public ArrayList<Funcionario> buscarNome(String nome) throws Exception {

        ArrayList<Funcionario> listaRetorno = new ArrayList<Funcionario>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Funcionario.class);
        criteria.add(Restrictions.ilike("nome", nome + "%"));
        criteria.addOrder(Order.asc("nome"));
        listaRetorno = (ArrayList<Funcionario>) criteria.list();
        sessao.close();
        return listaRetorno;
    }

    public Funcionario buscarPorCodigo(int codigo) throws Exception {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Funcionario funcionario = (Funcionario) sessao.get(Funcionario.class, codigo);
        sessao.close();
        return funcionario;
    }
    
    public ArrayList<Funcionario> buscarLogin(String login) throws Exception {

        ArrayList<Funcionario> listaRetorno = new ArrayList<Funcionario>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Funcionario.class);
        criteria.add(Restrictions.ilike("login", login));
        criteria.addOrder(Order.asc("login"));
        listaRetorno = (ArrayList<Funcionario>) criteria.list();
        sessao.close();
        return listaRetorno;
    }

}
