package com.diego699.attendance_sheet.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nome_evento")
    private String nomeEvento;
    @Column
    private List<LocalDate> datasEventos;
}
