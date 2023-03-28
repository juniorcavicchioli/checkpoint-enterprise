package br.com.fiap.checkpoint.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

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

    @ManyToOne
    @JoinColumn(name = "record_label_id")
    private RecordLabel recordLabel;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "artist_id")
    private RecordLabel artist;
}
