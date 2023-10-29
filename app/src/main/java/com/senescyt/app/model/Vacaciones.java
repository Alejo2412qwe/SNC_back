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
    @Column(name = "vacId")
    private Long vacId;

    @Column(name = "vacDetalle")
    private String vacDetalle;
    @Column(name = "vacSaldo")
    private double vacSaldo;
    @Column(name = "vacDiasAnticipacion")
    private int vacDiasAnticipacion;
    @Column(name = "vacDiasCaducados")
    private int vacDiasCaducados;
    @Column(name = "vacTotalDiasDisponibles")
    private int vacTotalDiasDisponibles;
    @Column(name = "vacDiasUsados")
    private double vacDiasUsados;
    @Column(name = "vacDiasGanados")
    private double vacDiasGanados;
    @Column(name = "vacFecha")
    private Date vacFecha;
    @Column(name = "vacEstado")
    private int vacEstado;

    @ManyToOne
    @JoinColumn(name = "usuId", referencedColumnName = "usuId")
    private Usuario usuId;

    @JsonIgnore
    @OneToMany(mappedBy = "vacId")
    private List<Periodo> listaPeriodo;


}
