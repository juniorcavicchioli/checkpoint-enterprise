package br.com.fiap.checkpoint.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="track_id")
    private Long id;
    @NotNull
    @Column(name = "track_name")
    private String name;
    @NotNull
    @Column(name = "track_length")
    private Duration length;
    @NotNull
    @Column(name = "track_size")
    private int size;
    @NotNull
    @Column(name = "track_price")
    private double price;
    @NotNull
    @Column(name = "track_language")
    private String language;
    @NotNull
    @Column(name = "track_producer")
    private String producer;
    @NotNull
    @Column(name = "track_songwriters")
    private String songwriters;
    @NotNull
    @Column(name = "track_released")
    private LocalDate released;

    @OneToMany(mappedBy = "track", cascade = CascadeType.ALL)
    private List<Purchase> purchases = new ArrayList<>();

    @OneToMany(mappedBy = "trackId", cascade = CascadeType.ALL)
    private List<GenreTrack> genreTracks = new ArrayList<>();

    @OneToMany(mappedBy = "track", cascade = CascadeType.ALL)
    private List<TrackArtist> trackArtists = new ArrayList<>();

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private List<AlbumTrack> albumTracks = new ArrayList<>();
}
