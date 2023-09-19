package com.senescyt.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Provincia")
public class Provincia implements Serializable {

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
    @Column(name = "proId")
    private Long proId;

    @Getter
    @Setter
    @Column(name = "proNombre")
    private String proNombre;

    @JsonIgnore
    @OneToMany(mappedBy = "proId")
    private List<Ciudad> listaCiudades;
}
