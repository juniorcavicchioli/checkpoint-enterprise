package br.com.fiap.checkpoint.models;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class AlbumTrack {
    @EmbeddedId
    @ManyToOne
    @JoinColumn(name="album_id")
    private Album album;
    @EmbeddedId
    @ManyToOne
    @JoinColumn(name="track_id")
    private Track trackId;
}
