package vehiculo.dominio;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Vehiculo implements Serializable {
     
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_cliente;
    
    private String dominio;
    private String marca;
    private String modelo;
    private String anio;
    private String tipo;
    private String combustible;
    private String color;
    private String observaciones;
    
    @OneToOne
    private Duenio titularDelVehiculo;

    public Vehiculo() {
    }

    public Vehiculo(int id_cliente, String dominio, String marca, String modelo, String anio, String tipo, String combustible, String color, String observaciones, Duenio titularDelVehiculo) {
        this.id_cliente = id_cliente;
        this.dominio = dominio;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.tipo = tipo;
        this.combustible = combustible;
        this.color = color;
        this.observaciones = observaciones;
        this.titularDelVehiculo = titularDelVehiculo;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Duenio getTitularDelVehiculo() {
        return titularDelVehiculo;
    }

    public void setTitularDelVehiculo(Duenio titularDelVehiculo) {
        this.titularDelVehiculo = titularDelVehiculo;
    }

   
    
}
