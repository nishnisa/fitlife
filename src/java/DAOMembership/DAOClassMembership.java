/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOMembership;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Classmembership;
import util.NewHibernateUtil;

/**
 *
 * @author RIMA
 */
@ManagedBean
public class DAOClassMembership {
     public List<Classmembership> retrieveClassmembership() {
        List ship = new ArrayList();
        Classmembership stud1 = new Classmembership();
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Classmembership");
            ship = query.list();
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return ship;
    }
    
    
    
    public List<Classmembership> getbyID(String idClassmembership){
       Classmembership cms = new Classmembership();
       List <Classmembership> iUsr = new ArrayList();
       
       Transaction trans = null;
       Session session = NewHibernateUtil.getSessionFactory().openSession();
       
       try {
           trans = session.beginTransaction();
           Query query = session.createQuery("from Classmembership where idClassmembership = :id");
           query.setString("id", idClassmembership);
           cms = (Classmembership) query.uniqueResult();
           iUsr = query.list();
           trans.commit();
       } catch (Exception e) {
           System.out.println(e);
       }
       return iUsr;
   }
    
   public void deleteCms(Integer idClassmembership){
       Transaction trans = null;
       Session session = NewHibernateUtil.getSessionFactory().openSession();
       try {
           trans = session.beginTransaction();
           Classmembership cms = (Classmembership) session.load(Classmembership.class, new Integer(idClassmembership));
           session.delete(cms);
           trans.commit();
       } catch (Exception e) {
           System.out.println(e);
       }
   }
   
   public void editCms(Classmembership cms){
       Transaction trans = null;
       Session session = NewHibernateUtil.getSessionFactory().openSession();
       try {
           trans = session.beginTransaction();
           session.update(cms);
           trans.commit();
       } catch (Exception e) {
           System.out.println(e);
       }
   }
   
   public void add_Cms(Classmembership cms) {
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(cms);
            trans.commit();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}