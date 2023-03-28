package br.com.fiap.checkpoint.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.net.URL;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class RecordLabel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="record_label_id")
    private Long id;

    @NotNull
    @Column(name = "record_label_name")
    private String recordLabelName;

    @NotNull
    private URL website; //poderia ser string

    @OneToMany(mappedBy = "recordLabel")
    private List<Album> album;
}
