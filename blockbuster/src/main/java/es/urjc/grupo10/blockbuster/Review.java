package es.urjc.grupo10.blockbuster;

public class Review {

    private String nombre;
    private String comentario;

    public Review(String nombre, String comentario) {
        this.nombre = nombre;
        this.comentario = comentario;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    // Métodos
    @Override
    public String toString() {
        return "Review [nombre=" + nombre + ", comentario=" + comentario + "]";
    }
}
