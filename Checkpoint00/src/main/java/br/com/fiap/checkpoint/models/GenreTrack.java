package br.com.fiap.checkpoint.models;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class GenreTrack {
    @EmbeddedId
    @ManyToOne
    @JoinColumn(name="genre_id")
    private Genre genreId;
    @EmbeddedId
    @ManyToOne
    @JoinColumn(name="track_id")
    private Track trackId;
}
