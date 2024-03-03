package org.example.domain.Cliente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import lombok.Data;


@Entity
@Data

public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombreCliente;
    private String sexo;
    private double peso;
    private Integer edad;
    private double talla;
    private String tipoActividad;
    private String observaciones;
    private double GER;
    private double GET;

    public Cliente(String nombreCliente, String sexo, double peso, Integer edad, double talla, String tipoActividad, String observaciones, double GER, double GET) {
        this.nombreCliente = nombreCliente;
        this.sexo = sexo;
        this.peso = peso;
        this.edad = edad;
        this.talla = talla;
        this.tipoActividad = tipoActividad;
        this.observaciones = observaciones;
        this.GER = GER;
        this.GET = GET;
    }

    public Cliente() {

    }
}
