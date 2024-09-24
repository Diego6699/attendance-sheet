package com.diego699.attendance_sheet;

import com.diego699.attendance_sheet.dao.EventoDAO;
import com.diego699.attendance_sheet.entity.Evento;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class AttendanceSheetApplication {

    public static void main(String[] args) {
        SpringApplication.run(AttendanceSheetApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(EventoDAO eventoDAO) {
        return runner -> {
            updateEvento(eventoDAO);

        };
    }

    private void updateEvento(EventoDAO eventoDAO) {
        System.out.println("Salvando ....");
        Evento theEvento = new Evento("Teste", LocalDate.now());
        theEvento = eventoDAO.update(theEvento);
        System.out.println("Savo: " + theEvento);
    }


}
