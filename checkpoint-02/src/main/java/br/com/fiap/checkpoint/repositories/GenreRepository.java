package br.com.fiap.checkpoint.repositories;

import br.com.fiap.checkpoint.models.Artist;
import br.com.fiap.checkpoint.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Long> {

    @Query(value = "SELECT * FROM genre WHERE genre_name like %?1%", nativeQuery = true)
    public List<Genre> findAllByName(String name);
}
