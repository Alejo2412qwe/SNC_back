package com.senescyt.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

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
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "horId")
    private Long horId;

    @Getter
    @Setter
    @Column(name = "horNumHoras")
    private String horNumHoras;

    @Getter
    @Setter
    @Column(name = "horHoraIngreso")
    private String horHoraIngreso;

    @Getter
    @Setter
    @Column(name = "horHoraSalida")
    private String horHoraSalida;

    @Getter
    @Setter
    @Column(name = "horHoraAlmuerzoInicio")
    private String horHoraAlmuerzoInicio;

    @Getter
    @Setter
    @Column(name = "horHoraAlmuerzoFin")
    private String horHoraAlmuerzoFin;

}
