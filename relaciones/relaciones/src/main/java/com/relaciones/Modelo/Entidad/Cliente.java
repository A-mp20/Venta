package com.relaciones.Modelo.Entidad;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    
    @OneToMany(mappedBy = "cliente")
    private List<Venta> ventas;

    public Long getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public List<Venta> getVentas() {
        return ventas;
    }
    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }


    
    

}
