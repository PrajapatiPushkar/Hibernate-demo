
import org.hibernate.Session;

public class HibernateDemoMain {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();

            UserClassHibernate user = new UserClassHibernate(1,"Alice");
            session.persist(user);

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtil.close();
        }
    }
}
