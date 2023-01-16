package vehiculo.persistencia;

import com.sun.istack.internal.logging.Logger;
import java.util.List;
import java.util.logging.Level;
import vehiculo.dominio.Duenio;
import vehiculo.dominio.Vehiculo;
import vehiculo.persistencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {
    DuenioJpaController duenioJpa = new DuenioJpaController();
    VehiculoJpaController vehiculoJpa = new VehiculoJpaController();

    public void guardar(Duenio duenio, Vehiculo vehiculo) {
        
        //crear en la BD el Dueño
        duenioJpa.create(duenio);
        
        //crear en la BD el Vehiculo
        vehiculoJpa.create(vehiculo);
        
    }

    public List<Vehiculo> traerVehiculos() {
        return vehiculoJpa.findVehiculoEntities();
    }

    public void borrarVehiculo(int num_cliente) {
       
        try {
            vehiculoJpa.destroy(num_cliente);
        } catch (NonexistentEntityException ex) {
            java.util.logging.Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }


    public Vehiculo traerVehiculo(int num_cliente) {
        return vehiculoJpa.findVehiculo(num_cliente);
    }

    public void modificarVehiculo(Vehiculo vehicu) {
        try {
            vehiculoJpa.edit(vehicu);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Duenio traerDuenio(int id_duenio) {
        return duenioJpa.findDuenio(id_duenio);
    }

    public void modificarDuenio(Duenio duenio) {
        try {
            duenioJpa.edit(duenio);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
