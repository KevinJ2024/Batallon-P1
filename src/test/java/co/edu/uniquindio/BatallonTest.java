package co.edu.uniquindio;

import org.junit.jupiter.api.*;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class BatallonTest {

    private static final Logger LOG = Logger.getLogger(BatallonTest.class.getName());

    BatallonTest() {

    }

    @DisplayName("Prueba assertEquals")
    @Test
    void testInicial() {
        LOG.info("Iniciando prueba Batallon...");

        int resultado = 1 + 2;

        assertEquals(3, resultado);

        LOG.info("Finalizando prueba Batallon...");
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
    void testRegistroVehiculoId() {
        LOG.info("Iniciando prueba de registro de vehiculo considerando id repetido");
        //Batallon de prueba
        Batallon batallonPrueba = new Batallon("123", "Batallon 1", "Tercera", "Quinto", 1);

        //Creacion de Vehiculo
        TransporteTropas transporte = new TransporteTropas("T-01", "Camión de tropas", 2020,
                12000, EstadoOperativo.DISPONIBLE, 25);

        //Registro de vehiculo
        boolean registroVehiculo = batallonPrueba.registrarVehiculo(transporte);

        assertTrue(registroVehiculo);
        LOG.info("Finalizando prueba de registro de vehiculo con id repetido");
    }

    // ------Ejemplos-----

    @DisplayName("Prueba assertNotEquals")
    @Test
    void testNotEquals() {
        LOG.info("Iniciando prueba Batallon...");

        String cadena = "Hola a todos";

        assertNotEquals("Adios", cadena);

        LOG.info("Finalizando prueba Batallon...");
    }

    @DisplayName("Prueba assertNull")
    @Test
    void testNull() {
        LOG.info("Iniciando prueba Batallon...");

        Batallon batallon = null;

        assertNull(batallon);

        LOG.info("Finalizando prueba Batallon...");
    }

    @DisplayName("Prueba assertNotNull")
    @Test
    void testNotNull() {
        LOG.info("Iniciando prueba Batallon...");

        Batallon batallon = new Batallon("01", "Cacique", "03", "Calarca", 3);

        assertNotNull(batallon);

        LOG.info(batallon.toString());
        LOG.info("Finalizando prueba Batallon...");
    }

    @DisplayName("Prueba assertTrue/assertFalse")
    @Test
    void testFalseTrue() {
        LOG.info("Iniciando prueba Batallon...");

        Batallon batallon = new Batallon("01", "Cacique", "03", "Calarca", 3);

        assertTrue(batallon.getNumero() < 5);
        assertFalse(batallon.getNombre().equals("Calarca cacique"));

        LOG.info(batallon.toString());
        LOG.info("Finalizando prueba Batallon...");
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