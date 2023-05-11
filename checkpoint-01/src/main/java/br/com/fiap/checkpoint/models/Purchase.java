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
    @ManyToOne(optional = true)
    @JoinColumn(name="email")
    private Customer customer;
    @EmbeddedId
    @ManyToOne(optional = false)
    @JoinColumn(name="track_id")
    private Track track;
    @NotNull
    @Column(name="payment_method")
    private String paymentMethod;
    @NotNull
    private LocalDate date; // !date é palavra chave no Oracle!
    @NotNull
    private LocalTime time;
}
