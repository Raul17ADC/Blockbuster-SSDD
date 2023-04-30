package es.urjc.grupo10.blockbuster;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private LocalDate date;
    private String info;

    public Review( String info) {
        
        this.info = info;
        this.date = LocalDate.now();
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    

    public String getInfo() {
        return info;
    }

    public void setInfo(String comentario) {
        this.info = comentario;
    }

    // Methods
    @Override
    public String toString() {
        return "Review [Fecha=" + date + ", comentario=" + info + "]";
    }

    
}
