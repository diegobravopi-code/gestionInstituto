package es.instituto.modelo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "alumno")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;
    @Column(nullable = false)
    private int edad;
    private Double nota;
    protected Alumno(){}
    public Alumno(String nombre, int edad, Double nota) {
        this.nombre = nombre;
        this.edad = edad;
        this.nota = nota;
    }
    public Alumno(Integer id, String nombre, int edad, Double nota) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.nota = nota;
    }
    @OneToMany(mappedBy = "alumno")
    private List<Matricula> matriculas = new ArrayList<>();

    public List<Matricula> getMatriculas() { return matriculas; }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public Double getNota() {
        return nota;
    }
    public void setNota(Double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return nombre + " (" + edad + " años, nota " + (nota == null ? "sin nota" : nota) + ")";
    }
}
