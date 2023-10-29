package com.senescyt.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Periodo")
public class Periodo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "periId")
    private Long periId;

    @Column(name = "periActual")
    private String periActual;
    @Column(name = "periAnterior")
    private String periAnterior;
    @Column(name = "periEstado")
    private int periEstado;

    @ManyToOne
    @JoinColumn(name = "vacId", referencedColumnName = "vacId")
    private Vacaciones vacId;

}
