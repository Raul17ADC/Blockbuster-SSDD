package es.urjc.grupo10.blockbuster;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Film {
    private Long code;
    private String title;
    private String director;
    private String scriptwriter;
    private String trailer;
    private String description;
    private String image;
    private double rating;
    private int likes;

    private List<String> actors = new ArrayList<>();
    private List<String> genres = new ArrayList<>();
    private List<String> reviews = new ArrayList<>();

    public Film() {
    }

    public Film(Long code, String title, String director, String scriptwriter, String trailer,
                String description, String image, double rating) {
        this.code = code;
        this.title = title;
        this.director = director;
        this.scriptwriter = scriptwriter;
        this.trailer = trailer;
        this.description = description;
        this.image = image;
        this.rating = rating;
        this.likes = 0 ;;
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

    public int getLikes() {
        return likes;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void addLike(){
        this.likes++;
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

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<String> getReviews() {
        return reviews;
    }

    public void setReviews(List<String> reviews) {
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

    // public String getReviewById(Long reviewId) {
    // for (String review : reviews) {
    // String[] parts = review.split(":");
    // int id = Integer.parseInt(parts[0].trim());
    // if (id == reviewId) {
    // return parts[1].trim();
    // }
    // }
    // return null;
    // }
}