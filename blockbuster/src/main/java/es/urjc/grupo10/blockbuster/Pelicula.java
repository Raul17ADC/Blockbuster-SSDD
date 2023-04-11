package es.urjc.grupo10.blockbuster;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pelicula {

    private Long id;
    private String titulo;
    private String director;
    private String guionista;
    private String trailer;
    private String descripcion;
    private String imagen;
    private double calificacion;
    private List<String> actores = new ArrayList<>();
    private List<String> generos = new ArrayList<>();
    private List<String> reviews = new ArrayList<>();

    public Pelicula() {
    }

    public Pelicula(Long id, String titulo, String director, String guionista , String trailer, String descripcion, String imagen,double calificacion) {
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.guionista = guionista;
        this.trailer = trailer;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.calificacion = calificacion;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGuionista() {
        return guionista;
    }

    public void setGuionista(String guionista) {
        this.guionista = guionista;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public List<String> getActores() {
        return actores;
    }

    public void setActores(List<String> actores) {
        this.actores = actores;
    }

    public List<String> getGeneros() {
        return generos;
    }

    public void setGeneros(List<String> generos) {
        this.generos = generos;
    }

    public List<String> getReviews() {
        return reviews;
    }

    /*public String getReviewById(Long reviewId) {
        for (String review : reviews) {
            String[] parts = review.split(":");
            int id = Integer.parseInt(parts[0].trim());
            if (id == reviewId) {
                return parts[1].trim();
            }
        }
        return null;
    }    */

    public void setReviews(List<String> reviews) {
        this.reviews = reviews;
    }

    @Override
public boolean equals(Object obj) {
    if (obj == null) {
        return false;
    }
    if (getClass() != obj.getClass()) {
        return false;
    }
    final Pelicula other = (Pelicula) obj;
    if (!Objects.equals(this.titulo, other.titulo)) {
        return false;
    }
    if (!Objects.equals(this.director, other.director)) {
        return false;
    }
    
    // comparar los demás atributos relevantes para determinar si dos películas son iguales
    return true;
}
    // Métodos
    @Override
    public String toString() {
        return "Pelicula [id=" + id + ", titulo=" + titulo + ", director=" + director + ", guionista=" + guionista
                + ", trailer=" + trailer + ", calificacion=" + calificacion + ", actores=" + actores + ", generos="
                + generos + ", reviews=" + reviews + "]";
    }
}