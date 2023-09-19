package com.senescyt.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Vacaciones")
public class Vacaciones implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vacId;

    private String vacDetalle;
    private double vacSaldo;
    private int vacDiasAnticipacion;
    private int vacDiasCaducados;
    private int vacTotalDiasDisponibles;
    private double vacDiasUsados;
    private double vacDiasGanados;
    private Date vacFecha;

    @ManyToOne
    @JoinColumn(name = "usuId", referencedColumnName = "usuId")
    private Usuario usuId;

    @JsonIgnore
    @OneToMany(mappedBy = "vacId")
    private List<Periodo> listaPeriodo;


}
