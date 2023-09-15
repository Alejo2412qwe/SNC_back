package com.senescyt.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Procesos")
public class Procesos /*zona*/ implements Serializable {

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
    @Column(name = "procId")
    private Long procId;

    @Getter
    @Setter
    @Column(name = "procNombre")
    private String procNombre;

    @JsonIgnore
    @OneToMany(mappedBy = "procId")
    private List<Subprocesos> listaSubprocesos;
}
