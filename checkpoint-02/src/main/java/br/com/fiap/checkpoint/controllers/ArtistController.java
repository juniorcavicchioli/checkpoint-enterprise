package br.com.fiap.checkpoint.controllers;

import br.com.fiap.checkpoint.models.Artist;
import br.com.fiap.checkpoint.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/artist")
public class ArtistController {

    @Autowired
    ArtistRepository artistRepository;

    private Artist getArtist(Long id) {
        return artistRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Artist not found"));
    }

    @PostMapping
    public ResponseEntity<Artist> addArtist(@RequestBody Artist artist) {
        artistRepository.save(artist);
        return ResponseEntity.status(HttpStatus.CREATED).body(artist);
    }

    @GetMapping("{id}")
    public Artist browseArtist(@PathVariable Long id) {
        return getArtist(id);
    }

    @GetMapping
    public Iterable<Artist> listArtists() {
        return artistRepository.findAll();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Artist> deleteArtist(@PathVariable Long id){
        var fundedArtist = getArtist(id);
        artistRepository.delete(fundedArtist);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Artist> updateArtist(@PathVariable Long id, @RequestBody Artist artist) {
        getArtist(id);
        artist.setId(id);
        artistRepository.save(artist);
        return ResponseEntity.ok(artist);
    }

    // Usando o nome
    @GetMapping("/name/{name}")
    public List<Artist> listArtistsByName(@PathVariable String name) {
        List<Artist> artists = artistRepository.findAllByName(name);
        if(artists.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Artists not found");
        }
        return artists;
    }

    // usando o tipo
    @GetMapping("/type/{type}")
    public List<Artist> listArtistsByType(@PathVariable String type) {
        List<Artist> artists = artistRepository.findAllByType(type);
        if(artists.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Artists not found");
        }
        return artists;
    }

}
