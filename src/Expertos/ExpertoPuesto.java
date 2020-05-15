/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Expertos;

import BDEstacionamientoV2.HibernateUtil;
import Modelo.Puesto;
import Modelo.Tipovehiculo;
import java.util.List;
import java.util.Vector;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author MARINA
 */
public class ExpertoPuesto implements Experto {

    
    @Override
    public List<Object> search(String param) {
        String hql = "from Puesto p";
        if (param != null) {
            hql = "from Puesto p WHERE p.numPuesto like :param";
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int persist(Object o) {
        Puesto p = (Puesto)o;
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
        Puesto p = (Puesto)o;
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
        Puesto p = (Puesto)o;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            //Puesto p = e.getPuesto();
            if(operation.equals("add")){
                session.persist(p);
            }else{
                session.merge(p);
            }
            session.getTransaction().commit();
            return 1;
        } catch (HibernateException he) {
            session.getTransaction().rollback();
            he.printStackTrace();
        }finally{
            
            session.disconnect();
            session.close();
        }
        
        return 0;
        
    }

    public List<Object> puestosDisponibles() {
        String hql = "from Puesto p WHERE p.estadoPuesto = 0";

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery(hql);
//            if(param != null){
//                q.setString("param", "%"+param+"%");
//            }
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
}
