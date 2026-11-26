package com.pagoflex.pagoflex_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "compromisos")
public class Compromiso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String usuarioRut;
    private String usuarioNombre;
    private String empresaNombre;
    private String descripcion;
    private Integer monto;
    private String fechaVencimiento;
    private String estado; // "PENDIENTE", "PAGADO", "ANULADO"

    public Compromiso() {}

    public Compromiso(String usuarioRut, String usuarioNombre, String empresaNombre,
                        String descripcion, Integer monto, String fechaVencimiento, String estado) {
        this.usuarioRut = usuarioRut;
        this.usuarioNombre = usuarioNombre;
        this.empresaNombre = empresaNombre;
        this.descripcion = descripcion;
        this.monto = monto;
        this.fechaVencimiento = fechaVencimiento;
        this.estado = estado;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsuarioRut() { return usuarioRut; }
    public void setUsuarioRut(String usuarioRut) { this.usuarioRut = usuarioRut; }

    public String getUsuarioNombre() { return usuarioNombre; }
    public void setUsuarioNombre(String usuarioNombre) { this.usuarioNombre = usuarioNombre; }

    public String getEmpresaNombre() { return empresaNombre; }
    public void setEmpresaNombre(String empresaNombre) { this.empresaNombre = empresaNombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Integer getMonto() { return monto; }
    public void setMonto(Integer monto) { this.monto = monto; }

    public String getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(String fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}