/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOTrainer;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Member;
import pojo.Trainer;
import util.NewHibernateUtil;

/**
 *
 * @author Nishrina
 */
@ManagedBean
public class DAOLoginTrainer {
        public List<Trainer> getBy(String email, String password) {
        Member u = new Member();
        List<Trainer> trainer = new ArrayList();

        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Trainer where email= :email AND password= :password");
            query.setString("email", email);
            query.setString("password", password);
            u = (Member) query.uniqueResult();
            trainer = query.list();

            trans.commit();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return trainer;
    }
    public DAOLoginTrainer() {
    }
    
}
