/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOClass;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Classes;
import util.NewHibernateUtil;

/**
 *
 * @author Nishrina
 */
@ManagedBean
@SessionScoped
public class DAOTampilClass {
    public List<Classes> ambilclass() {

        List<Classes> kar = new ArrayList<>();
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Classes"); // Sesuaikan dengan nama entitas Anda
            kar = query.list();
            trans.commit();
        } catch (Exception e) {
            if (trans != null) {
                trans.rollback(); // Rollback transaksi jika terjadi kesalahan
            }
            e.printStackTrace(); // Cetak kesalahan untuk pemecahan masalah
        } finally {
            session.close(); // Selalu pastikan untuk menutup sesi Hibernate
        }
        return kar;
    }

}
