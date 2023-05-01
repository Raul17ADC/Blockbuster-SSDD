package es.urjc.grupo10.blockbuster.Class;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  
    private Long actorCode;

    private String actorName;

    @ManyToMany
    private List<Film> films = new ArrayList<>();



    public Actor() {
    }
    
    public Actor(String actorName) {
        
        this.actorName = actorName;
        
    }

    public String getActorName(){
        return this.actorName;
    }


    public void addFilm(Film film) {
        films.add(film);
        
    }

    @Override
    public String toString() {
        return actorName ;   
                           
               
    }
}
