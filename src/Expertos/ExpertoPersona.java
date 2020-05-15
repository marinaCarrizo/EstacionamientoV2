/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Expertos;

import BDEstacionamientoV2.HibernateUtil;
import Modelo.Persona;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author MARINA
 */
public class ExpertoPersona implements Experto{
    

    
    @Override
    public List<Object> search(String param) {
        String hql = "from Persona p";
        if (param != null) {
            hql = "from Persona p WHERE p.nombrePersona like :param or p.dniPersona like :param";
        }

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery(hql);
            if(param != null){
                q.setString("param", "%"+param+"%");
            }
            List resultList = q.list();
            session.getTransaction().commit();
            session.disconnect();
            session.close();
            return resultList;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return null;
    }

    @Override
    public Object find(String param) {
        
        Persona persona = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery("from Persona p where p.idPersona = :personaid");
            q.setString("personaid", param);
            List resultList = q.list();
            persona = (Persona)resultList.get(0);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return persona;
    }

    @Override
    public int persist(Object o) {
        Persona p = (Persona)o;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            session.merge(p);
            
            session.getTransaction().commit();
            session.disconnect();
            session.close();
            return 1;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        
        return 0;
    }

    @Override
    public int delete(Object o) {
        Persona p = (Persona)o;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            session.delete(p);
            
            session.getTransaction().commit();
            session.disconnect();
            session.close();
            return 1;
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        
        return 0;
    }

    @Override
    public List<Object> search(String param, int column) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int persist(Object o, String operation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
