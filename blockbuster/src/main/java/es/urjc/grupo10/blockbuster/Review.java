package es.urjc.grupo10.blockbuster;

public class Review {

    private long id;
    private String nombre;
    private String comentario;

    public Review(Long id, String nombre, String comentario) {
        this.id = id;
        this.nombre = nombre;
        this.comentario = comentario;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    // Methods
    @Override
    public String toString() {
        return "Review [nombre=" + nombre + ", comentario=" + comentario + "]";
    }

    public String toStringReview() {
        return comentario;
    }
}
