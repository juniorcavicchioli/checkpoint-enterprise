package br.com.fiap.checkpoint.models;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class AlbumTrack {

    @EmbeddedId
    @ManyToOne(optional = false)
    @JoinColumn(name="album_id")
    private Album album;

    @EmbeddedId
    @ManyToOne(optional = false)
    @JoinColumn(name="track_id")
    private Track trackId;

}
