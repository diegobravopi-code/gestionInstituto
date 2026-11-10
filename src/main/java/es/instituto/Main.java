package es.instituto;

import es.instituto.modelo.Alumno;
import es.instituto.modelo.Matricula;
import org.hibernate.Session;

public class Main {
    static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String version = session.createNativeQuery("SELECT VERSION()", String.class)
                    .getSingleResult();
            System.out.println("Conectado a MySQL " + version);
            Alumno marta = session.find(Alumno.class, 4);                 // SELECT del alumno
            for (Matricula m : marta.getMatriculas()) {                   // SELECT de sus matrículas
                System.out.println(m.getCurso().getNombre() + " - " + m.getFecha());   // SELECT de cada curso
            }
        } finally {
            HibernateUtil.cerrar();
        }
    }
}