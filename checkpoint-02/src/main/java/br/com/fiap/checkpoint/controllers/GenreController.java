package br.com.fiap.checkpoint.controllers;

import br.com.fiap.checkpoint.models.Artist;
import br.com.fiap.checkpoint.models.Genre;
import br.com.fiap.checkpoint.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/genre")
public class GenreController {

    @Autowired
    GenreRepository genreRepository;

    private Genre getGenre(Long id) {
        return genreRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Genre not found"));
    }
    @GetMapping
    public Iterable<Genre> listGenres() {
        return genreRepository.findAll();
    }

    @GetMapping("{id}")
    public Genre browseGenre(@PathVariable Long id) {
        return getGenre(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Genre> deleteGenre(@PathVariable Long id){
        var fundedGenre = getGenre(id);
        genreRepository.delete(fundedGenre);
        return ResponseEntity.noContent().build();
    }

    @PostMapping ResponseEntity<Genre> addGenre(@RequestBody Genre genre) {
        genreRepository.save(genre);
        return ResponseEntity.status(HttpStatus.CREATED).body(genre);
    }

    @PutMapping("{id}")
    public ResponseEntity<Genre> updateGenre(@PathVariable Long id, @RequestBody Genre genre) {
        getGenre(id);
        genre.setId(id);
        genreRepository.save(genre);
        return ResponseEntity.ok(genre);
    }

    // Usando o nome
    @GetMapping("/name/{name}")
    public List<Genre> browseGenreByName(@PathVariable String name) {
        List<Genre> genres = genreRepository.findAllByName(name);
        if(genres.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Genres not found");
        }
        return genres;
    }
}
