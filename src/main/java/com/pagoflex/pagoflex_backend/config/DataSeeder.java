package com.pagoflex.pagoflex_backend.config;

import com.pagoflex.pagoflex_backend.model.Compromiso;
import com.pagoflex.pagoflex_backend.repository.CompromisoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner initDatabase(CompromisoRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(new Compromiso("12.345.678-9", "Camila Soto", "Inmobiliaria Andes", "Cuota Arriendo Noviembre", 450000, "2026-11-30", "PENDIENTE"));
                repository.save(new Compromiso("12.345.678-9", "Camila Soto", "Instituto Duoc", "Mensualidad Carrera", 210000, "2026-12-05", "PENDIENTE"));
                repository.save(new Compromiso("12.345.678-9", "Camila Soto", "Aseguradora Sur", "Seguro Automotriz", 58000, "2026-10-15", "PAGADO"));
                repository.save(new Compromiso("9.876.543-2", "Matías Rojas", "Crédito Consumo Flex", "Cuota 4 de 12", 125000, "2026-11-28", "PENDIENTE"));
            }
        };
    }
}