package com.diego699.attendance_sheet.dao;

import com.diego699.attendance_sheet.entity.Evento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EventoDAOEmpl implements EventoDAO {

    private EntityManager entityManager;

    public EventoDAOEmpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Evento> findAll(Pageable thePageable) {

        TypedQuery<Evento> query = entityManager.createQuery("FROM Evento", Evento.class);
        query.setFirstResult((int) thePageable.getOffset());
        query.setMaxResults(thePageable.getPageSize());
        List<Evento> eventoList = query.getResultList();
        System.out.println(eventoList);
        TypedQuery<Long> countQuery = entityManager.createQuery("SELECT COUNT(p) FROM Evento p", Long.class);
        long total = countQuery.getSingleResult();

        return new PageImpl<>(eventoList,thePageable,total);
    }

    @Override
    @Transactional(readOnly = true)
    public Evento findById(Integer theId) {
        return entityManager.find(Evento.class,theId);
    }

    @Override
    @Transactional
    public void save(Evento theEvento) {
        entityManager.persist(theEvento);
    }

    @Override
    @Transactional
    public Evento update(Evento theEvento) {
        return entityManager.merge(theEvento);
    }

    @Override
    @Transactional
    public void delete(Integer theId) {
        Evento tempEvento = entityManager.find(Evento.class,theId);
        entityManager.remove(tempEvento);
    }
}
