package es.urjc.grupo10.blockbuster.Repository;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.urjc.grupo10.blockbuster.Class.Film;

import java.util.List;
@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    
    @Query("SELECT f FROM Film f ORDER BY f.director ASC")
    List<Film> findAllOrderByDirector();
    @Query("SELECT f FROM Film f ORDER BY f.title ASC")
    List<Film> findAllOrderByTitle();
    @Query("SELECT f FROM Film f ORDER BY f.rating DESC")
    List<Film> findAllOrderByRating();
}
