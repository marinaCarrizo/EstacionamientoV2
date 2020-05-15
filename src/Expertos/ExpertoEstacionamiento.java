/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Expertos;

import BDEstacionamientoV2.HibernateUtil;
import Modelo.Estacionamiento;
import Modelo.Puesto;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author MARINA
 */
public class ExpertoEstacionamiento implements Experto{
    
    @Override
    public List<Object> search(String param, int view_all) {
        String condicion = "";
        if(view_all == 0){
            condicion = " and e.fechaSalida is null";
        }
        String hql = "from Estacionamiento e join fetch e.persona join fetch e.puesto join fetch e.tipovehiculo where e.numeroTicket > 0"+condicion;
        if (param != null) {
            hql = "from Estacionamiento e join fetch e.persona join fetch e.puesto join fetch e.tipovehiculo WHERE e.patente like :param"+condicion;
        }
        
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            Query q = session.createQuery(hql);
            if(param != null){
                q.setString("param", "%"+param+"%");
            }
            List resultList = q.list();
            session.getTransaction().commit();
            return resultList;
        } catch (HibernateException he) {
            session.getTransaction().rollback();
            he.printStackTrace();
        }finally{
            session.disconnect();
            session.close();
        }
        return null;
    }

    @Override
    public List<Object> search(String param) {
        String hql = "from Estacionamiento e join fetch e.persona join fetch e.puesto join fetch e.tipovehiculo where e.numeroTicket > 0 and e.fechaSalida is null";
        if (param != null) {
            hql = "from Estacionamiento e join fetch e.persona join fetch e.puesto join fetch e.tipovehiculo WHERE e.patente like :param and e.fechaSalida is null";
        }
        
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            Query q = session.createQuery(hql);
            if(param != null){
                q.setString("param", "%"+param+"%");
            }
            List resultList = q.list();
            session.getTransaction().commit();
            return resultList;
        } catch (HibernateException he) {
            session.getTransaction().rollback();
            he.printStackTrace();
        }finally{
            session.disconnect();
            session.close();
        }
        return null;
    }

    @Override
    public Object find(String param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int persist(Object o, String operation) {
        Estacionamiento e = (Estacionamiento)o;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            //Puesto p = e.getPuesto();
            if(operation.equals("add")){
                e.getPuesto().setEstadoPuesto(true);
                session.persist(e);
            }else{
                e.getPuesto().setEstadoPuesto(false);
                session.merge(e);
            }
            session.merge(e.getPuesto());
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

    @Override
    public int persist(Object o) {
        Estacionamiento e = (Estacionamiento)o;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            e.setFechaIngreso(new Timestamp(Calendar.getInstance().getTimeInMillis()));
            session.merge(e);
            
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
    public int delete(Object entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Estacionamiento> searchDesdeHasta(Timestamp desde, Timestamp hasta){
        
        String hql = "from Estacionamiento e join fetch e.persona join fetch e.puesto join fetch e.tipovehiculo where e.fechaIngreso > :desde and e.fechaIngreso < :hasta";
        
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            Query q = session.createQuery(hql);
            q.setTimestamp("desde", desde);
            q.setTimestamp("hasta", hasta);
            List resultList = q.list();
            session.getTransaction().commit();
            return resultList;
        } catch (HibernateException he) {
            session.getTransaction().rollback();
            he.printStackTrace();
        }finally{
            session.disconnect();
            session.close();
        }
        return null;
    }
    
}
