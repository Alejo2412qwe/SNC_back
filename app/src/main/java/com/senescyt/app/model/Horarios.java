package com.senescyt.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Horarios")
public class Horarios implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long horId;

    private String horNumHoras;
    private String horHoraIngreso;
    private String horHoraSalida;
    private String horHoraAlmuerzoInicio;
    private String horHoraAlmuerzoFin;

}
