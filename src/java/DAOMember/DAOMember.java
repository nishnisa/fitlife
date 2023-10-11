/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOMember;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Member;
import util.NewHibernateUtil;

/**
 *
 * @author Nishrina
 */
public class DAOMember {
       public List<Member> getbyID(String idMember){
       Member mem = new Member();
       List <Member> iUsr = new ArrayList();
       
       Transaction trans = null;
       Session session = NewHibernateUtil.getSessionFactory().openSession();
       
       try {
           trans = session.beginTransaction();
           Query query = session.createQuery("from Member where idMember = :id");
           query.setString("id", idMember);
           mem = (Member) query.uniqueResult();
           iUsr = query.list();
           trans.commit();
       } catch (Exception e) {
           System.out.println(e);
       }
       return iUsr;
   }
    
   public void deleteMem(Integer idMember){
       Transaction trans = null;
       Session session = NewHibernateUtil.getSessionFactory().openSession();
       try {
           trans = session.beginTransaction();
           Member mem = (Member) session.load(Member.class, new Integer(idMember));
           session.delete(mem);
           trans.commit();
       } catch (Exception e) {
           System.out.println(e);
       }
   }
       public void editMem(Member mem){
       Transaction trans = null;
       Session session = NewHibernateUtil.getSessionFactory().openSession();
       try {
           trans = session.beginTransaction();
           session.update(mem);
           trans.commit();
       } catch (Exception e) {
           System.out.println(e);
       }
   }
   
   public void add_Mem(Member mem) {
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(mem);
            trans.commit();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
