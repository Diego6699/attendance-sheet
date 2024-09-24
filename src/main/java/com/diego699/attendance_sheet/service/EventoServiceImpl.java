package com.diego699.attendance_sheet.service;

import com.diego699.attendance_sheet.dao.EventoDAO;
import com.diego699.attendance_sheet.entity.Evento;
import com.diego699.attendance_sheet.exception.EventoNotFoundException;
import jdk.jfr.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EventoServiceImpl implements EventoService{

    private EventoDAO eventoDAO;

    public EventoServiceImpl(EventoDAO eventoDAO) {
        this.eventoDAO = eventoDAO;
    }

    @Override
    public Page<Evento> findAll(Pageable thePageable) {

        return eventoDAO.findAll(thePageable);
    }

    @Override
    public Evento findById(Integer theId) {
        Evento evento = eventoDAO.findById(theId);
        if (evento == null){
            throw new EventoNotFoundException("Nao encontrado o id - " + theId);
        }
        return evento;
    }

    @Override
    public void save(Evento theEvento) {
        eventoDAO.save(theEvento);
    }

    @Override
    public Evento update(Evento theEvento) {
        return eventoDAO.update(theEvento);
    }

    @Override
    public void delete(Integer theId) {
        eventoDAO.delete(theId);
    }
}
