package com.diego699.attendance_sheet.rest;

import com.diego699.attendance_sheet.entity.Evento;
import com.diego699.attendance_sheet.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/eventos")
public class EventoRestController {

    private EventoService eventoService;

    @Autowired
    public EventoRestController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @GetMapping
    public ResponseEntity<Page<Evento>> findAll(Pageable pageable){
        Page<Evento> eventos = eventoService.findAll(pageable);
        return ResponseEntity.ok(eventos);
    }

    @GetMapping("/{theId}")
    public ResponseEntity<Evento> findById(@PathVariable("theId") Integer theId){
        Evento evento = eventoService.findById(theId);
        return ResponseEntity.ok(evento);
    }

    @PutMapping
    public ResponseEntity<Evento> update(@RequestBody Evento theEvento) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(theEvento.getId()).toUri();
        if (theEvento == null){
            throw new RuntimeException("Insercao nula");
        }
        return ResponseEntity.created(uri).body(theEvento);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Evento theEvento){
        if (theEvento == null){
            throw new RuntimeException("Insercao nula");
        }
        this.eventoService.save(theEvento);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{theId}")
    public ResponseEntity<Void> delete(@PathVariable("theId") Integer theId){
        eventoService.delete(theId);
        return  ResponseEntity.noContent().build();
    }

}
