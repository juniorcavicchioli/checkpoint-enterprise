package br.com.fiap.checkpoint.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_id")
    private Long id;

    @NotNull
    @Column(name = "album_name")
    private String albumName;

    @NotNull
    @Column(name = "album_type")
    private String albumType;

    @NotNull
    @Column(name = "album_released")
    private LocalDate albumReleased;

    @NotNull
    @Column(name = "album_recorded")
    private LocalDate albumRecorded;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "record_label_id")
    private RecordLabel recordLabel;

    @NotNull
    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private List<AlbumTrack> albumTracks =  new ArrayList<>();

}