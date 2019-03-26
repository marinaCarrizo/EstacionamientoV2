/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Expertos;

import BDEstacionamientoV2.HibernateUtil;
import Modelo.Usuario;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author VICTOR
 */
public class ExpertoUsuario implements Experto{
    

    
    @Override
    public List<Object> search(String param) {
        String hql = "from Usuario u join fetch u.persona join fetch u.perfil";
        if (param != null) {
            hql = "from Usuario u join fetch u.persona join fetch u.perfil WHERE u.nombreUsuario like :param";
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
        
        Usuario usuario = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery("from Usuario p where p.nombreUsuario = :user");
            q.setString("user", param);
            List resultList = q.list();
            usuario = (Usuario)resultList.get(0);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return usuario;
    }
    
    @Override
    public int persist(Object o, String operation) {
        Usuario u = (Usuario)o;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            if(operation.equals("add"))
                session.persist(u);
            else
                session.merge(u);
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
    public int delete(Object o) {
        Usuario u = (Usuario)o;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            session.delete(u);
            
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
    public int persist(Object entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
