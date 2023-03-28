package br.com.fiap.checkpoint.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class TrackArtist {
    @NotNull
    @EmbeddedId
    @ManyToOne(optional = false)
    @JoinColumn(name = "artist_id")
    private Artist artist;
    @NotNull
    @ManyToOne(optional = true)
    @JoinColumn(name = "featuring_artist_id")
    private Artist featuringArtist;
    @NotNull
    @EmbeddedId
    @ManyToOne(optional = false)
    @JoinColumn(name="track_id")
    private Track track;
}
