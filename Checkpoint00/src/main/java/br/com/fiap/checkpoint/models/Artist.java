package br.com.fiap.checkpoint.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="artist_id")
    private Long id;
    @NotNull
    @Column(name="artist_name")
    private String artistName;
    @NotNull
    @Column(name="artist_type")
    private String artistType;

    @OneToMany(mappedBy = "artist")
    private List<TrackArtist> tracks = new ArrayList<>();
    //private Set<TrackArtist> tracks = new HashSet<>();

    @OneToMany(mappedBy = "featuringArtist")
    private List<TrackArtist> featuringTracks = new ArrayList<>();
    //private Set<TrackArtist> featuringTracks = new HashSet<>();

    @OneToMany(mappedBy = "artist")
    private List<Album> albums = new ArrayList<>();
}
