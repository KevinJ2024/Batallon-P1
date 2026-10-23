package co.edu.uniquindio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VehiculoMilitarTest {
    private static final Logger LOG = Logger.getLogger(VehiculoMilitarTest.class.getName());

    VehiculoMilitarTest(){

    }

    @DisplayName("Prueba de eliminar vehiculo")
    @Test
    void testEliminarVehiculo() {
        LOG.info("Iniciando prueba de eliminacion de vehiculo");
        //Batallon de prueba
        Batallon batallonPrueba = new Batallon("123", "Batallon 1", "Tercera", "Quinto", 1);

        //Registro inicial de vehiculo
        TransporteTropas transporte = new TransporteTropas("T-01", "Camión de tropas", 2020,
                12000, EstadoOperativo.DISPONIBLE, 25);
        batallonPrueba.registrarVehiculo(transporte);

        //Eliminacion del vehiculo
        boolean vehiculoEliminado = batallonPrueba.eliminarVehiculo("T-01");
        assertTrue(vehiculoEliminado);

        Vehiculo vehiculoEncontrado = batallonPrueba.buscarVehiculo("T-01");
        assertNull(vehiculoEncontrado);
        LOG.info("Finalizando prueba de eliminacion de vehiculo");
    }

    @DisplayName("Prueba de actualizacion de vehiculo")
    @Test
    void testActualizacionVehiculo() {
        LOG.info("Iniciando prueba de actualizacion de vehiculo");
        //Batallon de prueba
        Batallon batallonPrueba = new Batallon("123", "Batallon 1", "Tercera", "Quinto", 1);
        //Creacion del vehiculo
        TransporteTropas transporte = new TransporteTropas("T-01", "Camión de tropas", 2020,
                20, EstadoOperativo.DISPONIBLE, 25);
        //Registro del vehiculo
        batallonPrueba.registrarVehiculo(transporte);

        //Consulta del vehiculo
        Vehiculo transporteEncontrado = batallonPrueba.buscarVehiculo("T-01");

        //Actualizacion de datos
        transporteEncontrado.setKilometraje(200);
        transporteEncontrado.setEstadoOperativo(EstadoOperativo.EN_MANTENIMIENTO);

        //Comprobar que se actualizen de manera correcta
        Assertions.assertEquals(200, transporteEncontrado.getKilometraje());
        Assertions.assertEquals(EstadoOperativo.EN_MANTENIMIENTO, transporteEncontrado.getEstadoOperativo());
        LOG.info("Finalizando prueba de actualizacion de vehiculo");
    }
}
