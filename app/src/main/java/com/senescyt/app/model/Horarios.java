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
    @Column(name = "horId")
    private Long horId;

    @Column(name = "horNumHoras")
    private String horNumHoras;
    @Column(name = "horHoraIngreso")
    private String horHoraIngreso;
    @Column(name = "horHoraSalida")
    private String horHoraSalida;
    @Column(name = "horHoraAlmuerzoInicio")
    private String horHoraAlmuerzoInicio;
    @Column(name = "horHoraAlmuerzoFin")
    private String horHoraAlmuerzoFin;

}
