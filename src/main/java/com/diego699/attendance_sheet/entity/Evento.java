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
    @Column(name = "data_evento")
    private LocalDate dataEvento;

    public Evento() {
    }

    public Evento(String nomeEvento, LocalDate dataEvento) {
        this.nomeEvento = nomeEvento;
        this.dataEvento = dataEvento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    @Override
    public String toString() {
        return "Evento{" + "id=" + id + ", nomeEvento='" + nomeEvento + '\'' + ", dataEvento=" + dataEvento + '}';
    }
}
