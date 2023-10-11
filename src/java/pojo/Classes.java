package pojo;
// Generated Oct 7, 2023 2:21:55 AM by Hibernate Tools 4.3.1


import DAOClass.DAOTampilClass;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.NewHibernateUtil;


/**
 * Classes generated by hbm2java
 */
@ManagedBean
public class Classes  implements java.io.Serializable {


     private int idClasses;
     private Exercise exercise;
     private String classesName;
     private Date duration;
     private int slots;
     private String images;
public int getDurationMinutes() {
    Time durationTime = (Time) getDuration();
    return convertTimeToMinutes(durationTime);
}
    @Override
    public String toString() {
        return "Classes{" + "idClasses=" + idClasses + ", classesName=" + classesName + ", duration=" + duration + ", slots=" + slots + '}';
    }
     private Set classmemberships = new HashSet(0);

    public Classes() {
    }

	
    public Classes(int idClasses, Exercise exercise, String classesName, Date duration, int slots) {
        this.idClasses = idClasses;
        this.exercise = exercise;
        this.classesName = classesName;
        this.duration = duration;
        this.slots = slots;
    }
    public Classes(int idClasses, Exercise exercise, String classesName, Date duration, int slots, Set classmemberships) {
       this.idClasses = idClasses;
       this.exercise = exercise;
       this.classesName = classesName;
       this.duration = duration;
       this.slots = slots;
       this.classmemberships = classmemberships;
    }
   
    public int getIdClasses() {
        return this.idClasses;
    }
    
    public void setIdClasses(int idClasses) {
        this.idClasses = idClasses;
    }
    public Exercise getExercise() {
        return this.exercise;
    }
    
    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
    public String getClassesName() {
        return this.classesName;
    }
    
    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }
    public Date getDuration() {
        return this.duration;
    }
    
    public void setDuration(Date duration) {
        this.duration = duration;
        
    }
    
    public int convertTimeToMinutes(Time time) {
    int totalMinutes = 0;
    if (time != null) {
        String[] parts = time.toString().split(":");
        if (parts.length == 3) {
            int hours = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            int seconds = Integer.parseInt(parts[2]);
            totalMinutes = (hours * 60) + minutes + (seconds > 30 ? 1 : 0); // Round up if seconds > 30
        }
    }
    return totalMinutes;
}
    
    public int getSlots() {
        return this.slots;
    }
    
    public void setSlots(int slots) {
        this.slots = slots;
    }
    
    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
    
    public Set getClassmemberships() {
        return this.classmemberships;
    }
    
    public void setClassmemberships(Set classmemberships) {
        this.classmemberships = classmemberships;
    }

    public List<Classes> tabelclass()
    {
        DAOTampilClass tdao=new DAOTampilClass();
        //System.out.println("hello world");
        List<Classes> kar = tdao.ambilclass();
        System.out.println(kar);
        return kar;
    }
    
 public Exercise getTest() {
    List<Exercise> exercises = new ArrayList();

    Transaction trans = null;
    Session session = NewHibernateUtil.getSessionFactory().openSession();
    try {
        trans = session.beginTransaction();
        Query query = session.createQuery("SELECT c.exercise FROM Classes c WHERE c.idClasses = :id");
        query.setParameter("id", idClasses);
        exercises = query.list();
        System.out.println(exercises);
        trans.commit();
    } catch (Exception e) {
        System.out.println("Error: " + e);
    } finally {
        session.close();
    }
    return exercises.isEmpty() ? null : exercises.get(0);
}




}


