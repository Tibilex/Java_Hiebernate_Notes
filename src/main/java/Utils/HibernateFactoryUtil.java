package Utils;

import Models.Note;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateFactoryUtil {
    private static SessionFactory _sessionFactory;
    private HibernateFactoryUtil() {}
    public static SessionFactory getSessionFactory(){
        if ( _sessionFactory == null ) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Note.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                _sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch ( Exception ex ) {
                System.out.println(ex.getMessage());
            }
        }
        return _sessionFactory;
    }
}
