package br.com.fiap.checkpoint.repositories;

import br.com.fiap.checkpoint.models.Genre;
import br.com.fiap.checkpoint.models.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrackRepository extends JpaRepository<Track, Long> {

    @Query(value = "SELECT * FROM track WHERE track_name like %?1%", nativeQuery = true)
    public List<Track> findAllByName(String name);

    @Query(value = "SELECT * FROM track WHERE track_language like %?1%", nativeQuery = true)
    public List<Track> findAllByLanguage(String name);
}
