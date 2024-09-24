package com.diego699.attendance_sheet.dao;

import com.diego699.attendance_sheet.entity.Evento;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EventoDAOEmpl implements EventoDAO {

    private EntityManager entityManager;

    public EventoDAOEmpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Evento update(Evento theEvento) {
        return entityManager.merge(theEvento);
    }
}
