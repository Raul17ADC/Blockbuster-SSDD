// not work should go into the java folder and work ass a service

class Pelicula {
  constructor(Portada, Titulo, Director, Guionista, Trailer, Valoracion) {
    this.Portada = Portada;
    this.Titulo = Titulo;
    this.Director = Director;
    this.Guionista = Guionista;
    this.Actores = [];
    this.Generos = [];
    this.Trailer = Trailer;
    this.Valoracion = Valoracion;
  }
}

function add_genero(pelicula, genero) {
  pelicula.Generos.push(this.genero);
}

function add_actor(pelicula, actor) {
  pelicula.actor.push(this.actor);
}

var oso = new pelicula(
  "Oso_vicioso.jpg",
  "Oso Vicioso",
  "Elizabeth Banks",
  "Jimmy Warden",
  "https://www.youtube.com/watch?v=CvYGl5BESEI&ab_channel=UniversalSpain",
  6.0
);
document.write("hola");
console.log("hola");
