package com.senescyt.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Zonales")
public class Zonales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "zonId")
    private Long zonId;

    @Column(name = "zonNombre")
    private String zonNombre;

    @Column(name = "zonCodigo")
    private String zonCodigo;
}
