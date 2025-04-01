package com.geracaooitobits.api.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Table(name = "address")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id") // nome da FK na tabela address
    private User user;
    @NotNull
    private String street;
    @NotNull
    private String number;
    @NotNull
    private String neighborhood;
    @NotNull
    private String city;
    @NotNull
    private String state;
    @NotNull
    private String zipCode;
    private String complement;
}
