package br.com.fiap.checkpoint.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "Customer")
public class Customer {

    @Id
    private String email;
    @NotNull
    private String name;
    @NotNull
    private String password;
    @NotNull
    private int age;
    @NotNull
    @Column(name = "card_information")
    private String cardInformation;
    @NotNull
    @Column(name = "IP_address")
    private String ipAddress;
    @NotNull
    private String device;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Purchase> purchases = new ArrayList<>();
}
