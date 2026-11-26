package com.pagoflex.pagoflex_backend.repository;

import com.pagoflex.pagoflex_backend.model.Compromiso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CompromisoRepository extends JpaRepository<Compromiso, Long> {
    List<Compromiso> findByUsuarioRut(String usuarioRut);
}