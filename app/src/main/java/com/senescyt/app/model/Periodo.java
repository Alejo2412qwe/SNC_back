package com.senescyt.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
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
    private Date periActual;
    @Column(name = "periAnterior")
    private Date periAnterior;
    @Column(name = "periEstado")
    private int periEstado;
    @Column(name = "diasAnticipacion")
    private double diasAnticipacion;

    @ManyToOne
    @JoinColumn(name = "vacId", referencedColumnName = "vacId")
    private Vacaciones vacId;

    // Añadir un método para calcular la diferencia en días y actualizar diasAnticipacion
    @PrePersist
    @PreUpdate
    private void actualizarDiasAnticipacion() {
        if (periActual != null && periAnterior != null) {
            // Convertir Date a LocalDate
            LocalDate fechaActual = periActual.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate fechaAnterior = periAnterior.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            // Calcular la diferencia en días
            diasAnticipacion = Math.abs(ChronoUnit.DAYS.between(fechaAnterior, fechaActual));
        }
    }
    @GetMapping("/diasAnticipacion")
    public double getDiasAnticipacion() {
        actualizarDiasAnticipacion();
        return diasAnticipacion;
    }
}
