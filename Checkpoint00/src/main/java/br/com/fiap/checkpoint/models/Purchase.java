package br.com.fiap.checkpoint.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Purchase {
    @EmbeddedId
    @ManyToOne
    @JoinColumn(name="email")
    private Customer customer;
    @EmbeddedId
    @ManyToOne
    @JoinColumn(name="track_id")
    private Track track;
    @Column(name="payment_method", nullable = false)
    private String paymentMethod;
    @NotNull
    private LocalDate date;
    @NotNull
    private LocalTime time;
}
