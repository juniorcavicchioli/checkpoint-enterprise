package br.com.fiap.checkpoint.models;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class TrackArtist {
    @EmbeddedId
    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artist;
    @ManyToOne
    @JoinColumn(name = "featuring_artist_id")
    private Artist featuringArtist;
    @EmbeddedId
    @ManyToOne
    @JoinColumn(name="track_id", nullable = false)
    private Track track;
}
