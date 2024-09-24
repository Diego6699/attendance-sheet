package com.diego699.attendance_sheet.service;

import com.diego699.attendance_sheet.dao.EventoDAO;
import com.diego699.attendance_sheet.entity.Evento;
import org.springframework.stereotype.Service;

@Service
public class EventoServiceImpl implements EventoService{

    private EventoDAO eventoDAO;

    public EventoServiceImpl(EventoDAO eventoDAO) {
        this.eventoDAO = eventoDAO;
    }

    @Override
    public Evento update(Evento theEvento) {
        return eventoDAO.update(theEvento);
    }
}
