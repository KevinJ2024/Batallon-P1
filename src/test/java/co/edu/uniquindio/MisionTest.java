package co.edu.uniquindio;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MisionTest {
    private static final Logger LOG = Logger.getLogger(MisionTest.class.getName());

    MisionTest() {

    }

    @DisplayName("Prueba Creacion de misiones")
    @Test
    void testRegistroMisiones() {
        LOG.info("Iniciando prueba de registro de mision");
        //Batallon de prueba
        Batallon batallonPrueba = new Batallon("123", "Batallon 1", "Tercera", "Quinto", 1);

        //Creacion y registro de vehiculos para asignar
        TransporteTropas transporte = new TransporteTropas("T-01", "Camión de tropas", 2020,
                12000, EstadoOperativo.DISPONIBLE, 25);
        Blindado blindado = new Blindado("B-01", "Vehículo blindado", 2021,
                8000, EstadoOperativo.DISPONIBLE, 4);
        batallonPrueba.registrarVehiculo(transporte);
        batallonPrueba.registrarVehiculo(blindado);

        //Creacion de la mision
        Mision mision = new Mision("M-01", LocalDate.of(2026, 10, 22), "Calarcá");
        //Asignacion de vehiculos a la mision
        batallonPrueba.asignarVehiculoMision("M-01", "T-01");
        batallonPrueba.asignarVehiculoMision("M-01", "A-01");

        //Registro de mision
        boolean registroMision = batallonPrueba.registrarMision(mision);
        assertTrue(registroMision);
        LOG.info("Finalizando prueba de registro de mision");
    }

    @DisplayName("Prueba de contabilizar misiones completadas")
    @Test
    void testContarMisiones() {
        LOG.info("Iniciando prueba de contabilizar misiones completadas");
        //Batallon de prueba
        Batallon batallonPrueba = new Batallon("123", "Batallon 1", "Tercera", "Quinto", 1);

        //Creacion y registro de un solo vehiculo
        TransporteTropas transporte = new TransporteTropas("T-01", "Camión de tropas", 2020,
                12000, EstadoOperativo.DISPONIBLE, 25);
        batallonPrueba.registrarVehiculo(transporte);

        //Creacion de multiples misiones
        Mision mision1 = new Mision("M-01", LocalDate.of(2026, 10, 22), "Calarcá");
        Mision mision2 = new Mision("M-02", LocalDate.of(2026, 10, 22), "Calarcá");
        Mision mision3 = new Mision("M-03", LocalDate.of(2026, 10, 22), "Calarcá");
        Mision mision4 = new Mision("M-04", LocalDate.of(2026, 10, 22), "Calarcá");
        //Asignacion de vehiculos
        mision1.asignarVehiculo(transporte);
        mision2.asignarVehiculo(transporte);
        mision3.asignarVehiculo(transporte);
        mision4.asignarVehiculo(transporte);
        //Asignacion de personal para pasar validacion de no estar vacio la lista de personal
        mision1.agregarPersonal("Ana Pérez");
        mision2.agregarPersonal("Ana Pérez");
        mision3.agregarPersonal("Ana Pérez");
        mision4.agregarPersonal("Ana Pérez");

        //Registro de las misiones
        batallonPrueba.registrarMision(mision1);
        batallonPrueba.registrarMision(mision2);
        batallonPrueba.registrarMision(mision3);
        batallonPrueba.registrarMision(mision4);

        mision1.iniciar(); //Se inicia antes de completar porque es condicion para poder completarla
        mision1.completar(); //Se completa la primera mision
        mision2.iniciar();
        mision2.completar();//Se repite con la 2
        mision3.iniciar();//Se deja el estado de la 3 en curso
        //La mision 4 no se altera su estado permaneciendo en planificada

        ArrayList<Mision> misionesCompletadas = batallonPrueba.obtenerMisionesCompletadas();
        //Se comprueba que el tamaño sea de dos que son las misiones completadas
        assertEquals(2, misionesCompletadas.toArray().length);
        LOG.info("Iniciando prueba de contabilizar misiones completadas");
    }
}
