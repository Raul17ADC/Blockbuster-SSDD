package es.urjc.grupo10.blockbuster;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping; 

public class Pelicula {
    private String Portada;
    private String Titulo;
    private String Director;
    private String Guionista;
    private ArrayList<String> Actores;
    private ArrayList<String> Generos;
    private String Trailer;
    private double Valoracion;
  
    public Pelicula(String Portada, String Titulo, String Director, String Guionista, String Trailer, double Valoracion) {
      this.Portada = Portada;
      this.Titulo = Titulo;
      this.Director = Director;
      this.Guionista = Guionista;
      this.Actores = new ArrayList<String>();
      this.Generos = new ArrayList<String>();
      this.Trailer = Trailer;
      this.Valoracion = Valoracion;
    }
  
    // Getters and Setters
    public String getPortada() {
      return Portada;
    }
  
    public void setPortada(String Portada) {
      this.Portada = Portada;
    }
  
    public String getTitulo() {
      return Titulo;
    }
  
    public void setTitulo(String Titulo) {
      this.Titulo = Titulo;
    }
  
    public String getDirector() {
      return Director;
    }
  
    public void setDirector(String Director) {
      this.Director = Director;
    }
  
    public String getGuionista() {
      return Guionista;
    }
  
    public void setGuionista(String Guionista) {
      this.Guionista = Guionista;
    }
  
    public ArrayList<String> getActores() {
      return Actores;
    }
  
    public void setActores(ArrayList<String> Actores) {
      this.Actores = Actores;
    }
  
    public ArrayList<String> getGeneros() {
      return Generos;
    }
  
    public void setGeneros(ArrayList<String> Generos) {
      this.Generos = Generos;
    }
  
    public String getTrailer() {
      return Trailer;
    }
  
    public void setTrailer(String Trailer) {
      this.Trailer = Trailer;
    }
  
    public double getValoracion() {
      return Valoracion;
    }
  
    public void setValoracion(double Valoracion) {
      this.Valoracion = Valoracion;
    }
  
    // Methods
    public void addActor(String actor) {
      this.Actores.add(actor);
    }
  
    public void removeActor(String actor) {
      this.Actores.remove(actor);
    }
  
    public void addGenero(String genero) {
      this.Generos.add(genero);
    }
  
    public void removeGenero(String genero) {
      this.Generos.remove(genero);
    }
  }
