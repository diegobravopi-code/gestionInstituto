package es.instituto.DAO;

import es.instituto.HibernateUtil;
import es.instituto.modelo.Alumno;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;
import java.util.Optional;

public class AlumnoDAO {

    private final SessionFactory sf = HibernateUtil.getSessionFactory();

    public Optional<Alumno> buscarPorId(int id) {
        try (Session session = sf.openSession()) {
            return Optional.ofNullable(session.find(Alumno.class, id));
        }
    }

    public List<Alumno> listar() {
        try (Session session = sf.openSession()) {
            return session.createSelectionQuery("from Alumno order by nombre", Alumno.class)
                    .getResultList();
        }
    }

    public void insertar(Alumno alumno) {
        sf.inTransaction(session -> session.persist(alumno));
    }

    public boolean actualizarNota(int id, Double nuevaNota) {
        return sf.fromTransaction(session -> {
            Alumno alumno = session.find(Alumno.class, id);
            if (alumno == null) {
                return false;
            }
            alumno.setNota(nuevaNota);     // UPDATE al confirmar
            return true;
        });
    }

    public boolean borrar(int id) {
        return sf.fromTransaction(session -> {
            Alumno alumno = session.find(Alumno.class, id);
            if (alumno == null) {
                return false;
            }
            session.remove(alumno);
            return true;
        });
    }
}