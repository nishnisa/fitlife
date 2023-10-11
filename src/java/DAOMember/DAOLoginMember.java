/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOMember;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Member;
import util.NewHibernateUtil;

/**
 *
 * @author Nishrina
 */
@ManagedBean
public class DAOLoginMember {
        public List<Member> getBy(String email, String password) {
        Member u = new Member();
        List<Member> user = new ArrayList();

        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Member where email= :email AND password= :password");
            query.setString("email", email);
            query.setString("password", password);
            u = (Member) query.uniqueResult();
            user = query.list();

            trans.commit();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return user;
    }
    public DAOLoginMember() {
    }
    
}
