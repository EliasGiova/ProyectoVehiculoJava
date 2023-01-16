package vehiculo.logica;

import java.util.List;
import vehiculo.dominio.Duenio;
import vehiculo.dominio.Vehiculo;
import vehiculo.persistencia.ControladoraPersistencia;

public class Controladora {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String dominio, String marca, String modelo,
            String anio, String color, String celular, String nombre,
            String dni, String observaciones, String combustible, String tipo) {
        //Creamos el Dueño
        Duenio duenio = new Duenio();
        duenio.setCelular(celular);
        duenio.setDni(dni);
        duenio.setTitular(nombre);

        //Creamos el Vehiculo
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setDominio(dominio);
        vehiculo.setMarca(marca);
        vehiculo.setModelo(modelo);
        vehiculo.setCombustible(combustible);
        vehiculo.setAnio(anio);
        vehiculo.setColor(color);
        vehiculo.setTipo(tipo);
        vehiculo.setObservaciones(observaciones);
        vehiculo.setTitularDelVehiculo(duenio);

        controlPersis.guardar(duenio, vehiculo);

    }

    public List<Vehiculo> traerVehiculos() {
        return controlPersis.traerVehiculos();
    }

    public void borrarVehiculo(int num_cliente) {
        controlPersis.borrarVehiculo(num_cliente);
    }

    public Vehiculo traerVehiculos(int num_cliente) {
        return controlPersis.traerVehiculo(num_cliente);
    }

    public void modificarVehiculo(Vehiculo vehicu, String dominio, String marca, String modelo, String anio, String color, String celular, String nombre, String dni, String observaciones, String combustible, String tipo) {
        //seteo nuevos valores vehiculo
        vehicu.setAnio(anio);
        vehicu.setColor(color);
        vehicu.setCombustible(combustible);
        vehicu.setDominio(dominio);
        vehicu.setMarca(marca);
        vehicu.setModelo(modelo);
        vehicu.setTipo(tipo);
        vehicu.setObservaciones(observaciones);
        //modifico vehiculo
        controlPersis.modificarVehiculo(vehicu);
        //seteo valores nuevos dueño
        Duenio duenio = this.buscarDuenio(vehicu.getTitularDelVehiculo().getId_duenio());
        duenio.setCelular(celular);
        duenio.setDni(dni);
        duenio.setTitular(nombre);
        //modifico dueño
        this.modificarDuenio(duenio);
    }

    private Duenio buscarDuenio(int id_duenio) {
        return controlPersis.traerDuenio(id_duenio);
    }

    private void modificarDuenio(Duenio duenio) {
        controlPersis.modificarDuenio(duenio);
    }
}
