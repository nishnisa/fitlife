/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOAdmin;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Admin;
import util.NewHibernateUtil;
/**
 *
 * @author nishrina
 */
@ManagedBean
public class DAOLoginAdmin {
     public void addAdmin(Admin Admin)
    {
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            session.save(Admin);
            trans.commit();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public void deleteAdmin(String username)
    {
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            Admin prod=(Admin)session.load(Admin.class, new String(username));
            session.delete(prod);
            trans.commit();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public List<Admin> getbyID(String username)
    {
        List<Admin> admin=new ArrayList();
       
         Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            Query query=session.createQuery("from Admin where username= :username");
            query.setString("username", username);
            admin=query.list();
            
            trans.commit();
        }
        catch(Exception e)
        {
            
        }
        return admin;
    }
    
    public List<Admin> retrieveAdmin()
    {
       
        List prod=new ArrayList();
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try
        {
            trans=session.beginTransaction();
            Query query=session.createQuery("from Admin");
            prod=query.list();
         
            trans.commit();
            
        }
        catch(Exception e)
        {

        }
        return prod;
    }
    
    public void updateAdmin(Admin tbladmin)
    {
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            session.update(tbladmin);
            trans.commit();
        }
        catch(Exception e)
        {
            
        }   
    }   
    
    public List<Admin> validateLogin(String username, String password)
    {
        List<Admin> admin1=new ArrayList();
       
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            Query query=session.createQuery("from Admin where username= :username and password= :password");
            query.setString("username", username);
            query.setString("password", password);
            admin1=query.list();
            
            trans.commit();
        }
        catch(Exception e)
        {
            
        }
        return admin1;
    }
}