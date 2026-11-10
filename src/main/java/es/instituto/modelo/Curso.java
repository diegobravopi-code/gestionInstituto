package es.instituto.modelo;

public class Curso {
    private Integer id;
    private String nombre;
    private int plazasLibres;

    protected Curso() { }

    public Curso(String nombre, int plazasLibres) {
        this.nombre = nombre;
        this.plazasLibres = plazasLibres;
    }

    public Integer getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getPlazasLibres() { return plazasLibres; }
    public void setPlazasLibres(int plazasLibres) { this.plazasLibres = plazasLibres; }

    @Override
    public String toString() {
        return nombre + " (" + plazasLibres + " plazas libres)";
    }
}
