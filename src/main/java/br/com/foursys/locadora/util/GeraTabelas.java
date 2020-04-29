package br.com.foursys.locadora.util;


public class GeraTabelas {
    
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory().openSession();
        System.out.println("Tabela(s) criada com sucesso!");
        System.exit(0);
    }
    
}
