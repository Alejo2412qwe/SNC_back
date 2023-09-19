package com.senescyt.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Ciudad")
@Data
public class Ciudad implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ciuId")
    private Long ciuId;

    @Column(name = "ciuNombre")
    private String ciuNombre;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "proId", referencedColumnName = "proId")
    private Provincia proId;

    @JsonIgnore
    @OneToMany(mappedBy = "ciuId")
    private List<Persona> listaPersonas;
}
