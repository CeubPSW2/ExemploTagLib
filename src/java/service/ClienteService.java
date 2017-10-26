/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import configuracao.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author alexandretorres
 */
public class ClienteService {
    private static List<Cliente> clientes;


    
    public static List<Cliente> obtemClientes(){
        SessionFactory sf = null;
        Session session = null;

        List<Cliente> clientes = null;
        
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            
            session.beginTransaction();
            
            Query query = session.createQuery("FROM Cliente");
            clientes = query.list();
            
            session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if ( session != null)
                session.close();
        }     
        
        return clientes;
        
    }
    public static void insereClientes(){
        
        SessionFactory sf = null;
        Session session = null;

        clientes = new ArrayList<>();

        clientes.add( new Cliente( 1, "Frodo Baggins", "2345678909"));
        clientes.add( new Cliente( 2, "Bilbo Baggins", "48732682912"));
        clientes.add( new Cliente( 3, "Sauron Corintians", "38576139571"));
        clientes.add( new Cliente( 4, "Galadriel Diva", "57084290572"));
        clientes.add( new Cliente( 5, "Nazgul Flamenguista", "2849750284"));            
        
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            
            session.beginTransaction();
            
            for (Cliente cliente : clientes) {
                session.save(cliente);
                
            }
            
            session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if ( session != null)
                session.close();
        }
        
    }    
    
    public static void ativaDesativa(int id){
        
        SessionFactory sf = null;
        Session session = null;
        
        //Cliente cliente = obtemCliente(id);
        Cliente cliente = null;

        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            
            session.beginTransaction();
            cliente = (Cliente)session.get(Cliente.class, id);
            cliente.setAtivo(!cliente.isAtivo());
            
            session.update(cliente);
            
            session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if ( session != null)
                session.close();
        }

    }
    
}
