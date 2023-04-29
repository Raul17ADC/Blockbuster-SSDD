package es.urjc.grupo10.blockbuster;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long> {
    
   /*/  public Collection<Film> getNum(int i) {
        return filmHashMap.values()
                        .stream()
                        .limit(i)
                        .collect(Collectors.toList());
}

public Collection<Film> getAll() {
        return filmHashMap.values();
}

public Film getFilmById(Long id) {
        return filmHashMap.get(id);
}

public Collection<Film> getFilmsByGenre(String genero) {
        Collection<Film> films = getAll();
        Collection<Film> filmsByGenre = new ArrayList<>();
        for (Film film : films) {
                if (film.getGenres().contains(genero)) {
                        filmsByGenre.add(film);
                }
        }
        return filmsByGenre;
}/*/
}
