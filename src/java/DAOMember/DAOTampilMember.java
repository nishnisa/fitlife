package DAOMember;


import static java.lang.System.console;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Member;
import util.NewHibernateUtil;

public class DAOTampilMember {
    public List<Member> ambilmember() {

        List<Member> kar = new ArrayList<>();
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Member"); // Sesuaikan dengan nama entitas Anda
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
    final String update = "UPDATE Member set memberName=n, email=e, password=pw, phone=pn, address=a, dateBirth=dob where idMember=i ;";
    public void editMember(Member member) {
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery(update);
            query.setParameter("n", member.getMemberName());
            query.setParameter("e", member.getEmail());
            query.setParameter("pw", member.getPassword());
            query.setParameter("a", member.getAddress());
            query.setParameter("pn", member.getPhone());
            query.setParameter("dob", member.getDateBirth());
            query.setParameter("i", member.getIdMember());
            query.executeUpdate();
            trans.commit();
        } catch (   Exception e) {
            if (trans != null) {
                trans.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();}
        
    }

    public List<Member> getbyID(int id) {
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        List<Member> member2 = new ArrayList<>();
        try {
            Member member = new Member();
            trans = session.beginTransaction();
            Query query = session.createQuery("Select * from Member where idMember= :id"); // Sesuaikan dengan nama kolom ID yang benar
            query.setInteger("id",member.getIdMember());
            member2 = query.list();
            trans.commit();
        } catch (Exception e) {
            if (trans != null) {
//                console.log(e);
                trans.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return member2;
    }
}