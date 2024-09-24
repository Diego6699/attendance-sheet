package com.diego699.attendance_sheet.dao;


import com.diego699.attendance_sheet.entity.Evento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EventoDAO {

    Page<Evento> findAll(Pageable thePageable);
    Evento findById(Integer theId);
    void save(Evento theEvento);
    Evento update(Evento theEvento);
    void delete(Integer theId);
}
