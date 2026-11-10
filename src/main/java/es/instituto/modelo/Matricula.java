package es.instituto.modelo;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "matricula")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @Column(nullable = false)
    private LocalDate fecha;

    protected Matricula() { }

    public Matricula(Alumno alumno, Curso curso, LocalDate fecha) {
        this.alumno = alumno;
        this.curso = curso;
        this.fecha = fecha;
    }

    public Integer getId() { return id; }
    public Alumno getAlumno() { return alumno; }
    public Curso getCurso() { return curso; }
    public void setCurso(Curso curso) { this.curso = curso; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
}