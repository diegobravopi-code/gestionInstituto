package es.instituto;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public final class HibernateUtil {
    private static final SessionFactory SESSION_FACTORY = construir();
    private HibernateUtil(){}
    private static SessionFactory construir() {
        try {
            // configure() lee hibernate.cfg.xml de la raíz del classpath
            return new Configuration().configure().buildSessionFactory();
        } catch (HibernateException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }
    public static void cerrar() {
        SESSION_FACTORY.close();
    }
}