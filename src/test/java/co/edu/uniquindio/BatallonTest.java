package co.edu.uniquindio;

import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class BatallonTest {

    private static final Logger LOG = Logger.getLogger(BatallonTest.class.getName());

    BatallonTest() {

    }

    @DisplayName("Prueba Registro de vehiculos")
    @Test
    void testRegistroVehiculosConsulta() {
        LOG.info("Iniciando prueba de registro de vehiculo");
        //Batallon de prueba
        Batallon batallonPrueba = new Batallon("123", "Batallon 1", "Tercera", "Quinto", 1);

        //Informacion de vehiculos para la prueba
        TransporteTropas transporte = new TransporteTropas("T-01", "Camión de tropas", 2020,
                12000, EstadoOperativo.DISPONIBLE, 25);
        Blindado blindado = new Blindado("B-01", "Vehículo blindado", 2021,
                8000, EstadoOperativo.DISPONIBLE, 4);
        Apoyo apoyo = new Apoyo("A-01", "Ambulancia", 2022,
                5000, EstadoOperativo.DISPONIBLE, TipoFuncion.MEDICO);

        /*
        LLamadas de registro de vehiculo y del metodo para encontrar el mismo registrado
         */

        //Transporte
        batallonPrueba.registrarVehiculo(transporte);
        Vehiculo vehiculoTransporteEncontrado = batallonPrueba.buscarVehiculo("T-01");

        //Blindado
        batallonPrueba.registrarVehiculo(blindado);
        Vehiculo vehiculoBlindadoEncontrado = batallonPrueba.buscarVehiculo("B-01");

        //Apoyo
        batallonPrueba.registrarVehiculo(apoyo);
        Vehiculo vehiculoApoyoEncontrado = batallonPrueba.buscarVehiculo("A-01");

        //Equals
        assertEquals(transporte, vehiculoTransporteEncontrado);
        assertEquals(blindado, vehiculoBlindadoEncontrado);
        assertEquals(apoyo, vehiculoApoyoEncontrado);

        LOG.info("Finalizando prueba de registro de vehiculo");
    }

    @DisplayName("Prueba de Registro sin ID repetido")
    @Test
    void testRegistroVehiculoTrue() {
        LOG.info("Iniciando prueba de registro de vehiculo considerando id repetido validando que sea true");
        //Batallon de prueba
        Batallon batallonPrueba = new Batallon("123", "Batallon 1", "Tercera", "Quinto", 1);

        //Creacion de Vehiculo
        TransporteTropas transporte = new TransporteTropas("T-01", "Camión de tropas", 2020,
                12000, EstadoOperativo.DISPONIBLE, 25);

        //Registro de vehiculo
        boolean registroVehiculo = batallonPrueba.registrarVehiculo(transporte);

        assertTrue(registroVehiculo);
        LOG.info("Finalizando prueba de registro de vehiculo con id repetido validando que sea true");
    }

    @DisplayName("Prueba de retorno false registro de vehiculo")
    @Test
    void testRegistroVehiculoFalse() {
        LOG.info("Iniciando prueba de registro de vehiculo considerando id repetido validando que sea false");
        //Batallon de prueba
        Batallon batallonPrueba = new Batallon("123", "Batallon 1", "Tercera", "Quinto", 1);

        //Creacion de Vehiculo
        TransporteTropas transporte = new TransporteTropas("T-01", "Camión de tropas", 2020,
                12000, EstadoOperativo.DISPONIBLE, 25);
        Blindado blindado = new Blindado("T-01", "Vehículo blindado", 2021,
                8000, EstadoOperativo.DISPONIBLE, 4);

        //Registro de vehiculo
        batallonPrueba.registrarVehiculo(transporte);
        //Registro de otro vehiculo con mismo id del anterior
        boolean registroVehiculoBlindado = batallonPrueba.registrarVehiculo(blindado);

        assertFalse(registroVehiculoBlindado);
        LOG.info("Finalizando prueba de registro de vehiculo con id repetido validando que sea false");
    }

    @DisplayName("Prueba de consulta de vehiculo")
    @Test
    void testConsultaVehiculo() {
        LOG.info("Iniciando prueba de consulta de vehiculos existentes e inexistentes");
        //Batallon de prueba
        Batallon batallonPrueba = new Batallon("123", "Batallon 1", "Tercera", "Quinto", 1);

        //Creacion de vehiculo
        TransporteTropas transporte = new TransporteTropas("T-01", "Camión de tropas", 2020,
                12000, EstadoOperativo.DISPONIBLE, 25);

        //Registro de vehiculo
        batallonPrueba.registrarVehiculo(transporte);
        String id = batallonPrueba.buscarVehiculo("T-01").id;

        //Asserts para buscar un vehiculo que si existe y otro que no
        Assertions.assertEquals(transporte.id, id);
        Assertions.assertNull(batallonPrueba.buscarVehiculo("2"));
        LOG.info("Finalizando prueba de consulta de vehiculos existentes e inexistentes");
    }

    //@BeforeEach
    void ejecutarAntes() {
        LOG.warning("Ejecucion del BeforeEach");
    }

    //    @AfterEach
    void ejecutarDespues() {
        LOG.warning("Ejecucion del AfterEach");
    }

}