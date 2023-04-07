

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class Pelicula {
  private String portada;
  private String titulo;
  private String director;
  private String guionista;
  private ArrayList<String> actores;
  private ArrayList<String> generos;
  private String trailer;
  private double valoracion;
  private Long id;

  public Pelicula( long id,String portada, String titulo, String director, String guionista, String trailer, double valoracion) {
    this.id = id;
    this.portada = portada;
    this.titulo = titulo;
    this.director = director;
    this.guionista = guionista;
    this.actores = new ArrayList<String>();
    this.generos = new ArrayList<String>();
    this.trailer = trailer;
    this.valoracion = valoracion;
  }

  // Getters and Setters
  public String getPortada() {
    return portada;
  }

  public void setPortada(String portada) {
    this.portada = portada;
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

  public ArrayList<String> getActores() {
    return actores;
  }

  public void setActores(ArrayList<String> actores) {
    this.actores = actores;
  }

  public ArrayList<String> getGeneros() {
    return generos;
  }

  public void setGeneros(ArrayList<String> generos) {
    this.generos = generos;
  }

  public String getTrailer() {
    return trailer;
  }

  public void setTrailer(String trailer) {
    this.trailer = trailer;
  }

  public double getValoracion() {
    return valoracion;
  }

  public void setValoracion(double valoracion) {
    this.valoracion = valoracion;
  }

  // Methods
  public void addActor(String actor) {
    this.actores.add(actor);
  }

  public void removeActor(String actor) {
    this.actores.remove(actor);
  }

  public void addGenero(String genero) {
    this.generos.add(genero);
  }

  public void removeGenero(String genero) {
    this.generos.remove(genero);
  }
  
  public void setId(Long id) {
    this.id = id;
}

}
