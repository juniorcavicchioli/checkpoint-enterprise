package br.com.fiap.checkpoint.controllers;

import br.com.fiap.checkpoint.models.Genre;
import br.com.fiap.checkpoint.models.Track;
import br.com.fiap.checkpoint.repositories.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/track")
public class TrackController {

    @Autowired
    TrackRepository trackRepository;

    private Track getTrack(Long id) {
        return trackRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Track not found"));
    }
    @GetMapping
    public Iterable<Track> listTracks() {
        return trackRepository.findAll();
    }

    @GetMapping("{id}")
    public Track browseTrack(@PathVariable Long id) {
        return getTrack(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Track> deleteTrack(@PathVariable Long id){
        var fundedTrack = getTrack(id);
        trackRepository.delete(fundedTrack);
        return ResponseEntity.noContent().build();
    }

    @PostMapping ResponseEntity<Track> addTrack(@RequestBody Track track) {
        trackRepository.save(track);
        return ResponseEntity.status(HttpStatus.CREATED).body(track);
    }

    @PutMapping("{id}")
    public ResponseEntity<Track> updateTrack(@PathVariable Long id, @RequestBody Track track) {
        getTrack(id);
        track.setId(id);
        trackRepository.save(track);
        return ResponseEntity.ok(track);
    }

    // Usando o nome
    @GetMapping("/name/{name}")
    public List<Track> listTracksByName(@PathVariable String name) {
        List<Track> tracks = trackRepository.findAllByName(name);
        if(tracks.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tracks not found");
        }
        return tracks;
    }

    // Usando o idioma
    @GetMapping("/language/{language}")
    public List<Track> listTracksByLanguage(@PathVariable String language) {
        List<Track> tracks = trackRepository.findAllByLanguage(language);
        if(tracks.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tracks not found");
        }
        return tracks;
    }
}
