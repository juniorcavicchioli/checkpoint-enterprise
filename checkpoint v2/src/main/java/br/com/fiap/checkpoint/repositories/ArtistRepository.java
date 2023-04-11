package br.com.fiap.checkpoint.repositories;

import br.com.fiap.checkpoint.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

    @Query(value = "SELECT * FROM artist WHERE artist_name like %?1%", nativeQuery = true)
    public List<Artist> findAllByName(String name);

    @Query(value = "SELECT * FROM artist WHERE artist_type like %?1%", nativeQuery = true)
    public List<Artist> findAllByType(String type);

}