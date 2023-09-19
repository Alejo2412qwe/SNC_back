package com.senescyt.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Vacaciones")
public class Vacaciones {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_vacaciones;

    private String Detalle_vacc;
    private double Saldo_vacc;
    private int DiasAnticipacion_vacc;
    private int DiasCaducados_vacc;
    private int totalDiasDisponibles_vacc;
    private double diasUsados_vacc;
    private double diasGan_vacc;
    private Date fecha;
    private int periodo;

    @ManyToOne
    @JoinColumn(name = "idPeriodo", referencedColumnName = "idPeriodo")
    private Periodo idPeriodo;

    @JsonIgnore
    @OneToMany(mappedBy = "id_vacaciones")
    private List<Usuario> listaUsuarios;
}
