package es.urjc.grupo10.blockbuster.Class;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  
    private Long code;

    private String title;
    private String director;
    private String scriptwriter;
    private String trailer;
    private String description;
    private String image;
    private double rating;
    
    @ManyToMany
    private List<Actor> actors = new ArrayList<>();
    
    private List<String> genres = new ArrayList<>();
    
    @OneToMany(cascade=CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    
    public Film() {
    }

    public Film( String title, String director, String scriptwriter, String trailer, String description,
            String image, double rating) {
        
        this.title = title;
        this.director = director;
        this.scriptwriter = scriptwriter;
        this.trailer = trailer;
        this.description = description;
        this.image = image;
        this.rating = rating;
    }

    // Getters and setters
    public Long getId() {
        return code;
    }

    public void setId(Long id) {
        this.code = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getScriptwriter() {
        return scriptwriter;
    }

    public void setScriptwriter(String scriptwriter) {
        this.scriptwriter = scriptwriter;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void addActors(Actor actor) {
        this.actors.add(actor);
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review) {
        reviews.add(review);
        
    }

    public void removeReview(Review review) {
        reviews.remove(review);
        
    }
    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    // Methods
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Film other = (Film) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.director, other.director)) {
            return false;
        }
        // Compare the other relevant attributes to determine if two movies are the same
        return true;
    }

    @Override
    public String toString() {
        return "Film [id=" + code + ", title=" + title + ", director=" + director + ", scriptwriter=" + scriptwriter
                + ", trailer=" + trailer + ", rating=" + rating + ", actors=" + actors + ", genres="
                + genres + ", reviews=" + reviews + "]";
    }

   
}