package com.senescyt.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ipPermitidas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ipId")
    private Long ipId;

    @Column(name = "ipPermitida")
    private String ipPermitida;
}
