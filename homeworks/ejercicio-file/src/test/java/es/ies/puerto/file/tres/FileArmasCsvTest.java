package es.ies.puerto.file.tres;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static utilidades.UtilClassTest.MESSAGE_ERROR;

class FileArmasCsvTest {

    FileArmasCsv persistencia;
    List<Arma> armas;

    @BeforeEach
    void beforeEach() {
        persistencia = new FileArmasCsv();
        armas = persistencia.obtenerArmas();
    }

    @Test
    void obtenerArmasTest() {
        Assertions.assertFalse(armas.isEmpty(),
                MESSAGE_ERROR);
        Assertions.assertEquals(5, armas.size(),
                MESSAGE_ERROR);
    }

    @Test
    void obtenerArmaTest() {
        String idBuscar = "EX001";
        Arma ArmaBuscar = new Arma(idBuscar);
        ArmaBuscar = persistencia.obtenerArma(ArmaBuscar);
        Assertions.assertEquals(ArmaBuscar.getId(),idBuscar,
                MESSAGE_ERROR);
        Assertions.assertNotNull(ArmaBuscar.getNombre(),
                MESSAGE_ERROR);
        Assertions.assertTrue (ArmaBuscar.getOrigen().equals("Camelot"),
                MESSAGE_ERROR);
        Assertions.assertNotNull(ArmaBuscar.getOrigen().equals("Camelot"),
                MESSAGE_ERROR);
    }

    @Test
    void addDeleteArmaTest() {
        int numArmasInicial = armas.size();
        Arma armaInsertar = new Arma();
        persistencia.addArma(armaInsertar);
        armas = persistencia.obtenerArmas();
        int numArmasInsertar = armas.size();
        Assertions.assertTrue(armas.contains(armaInsertar),
                MESSAGE_ERROR);
        Assertions.assertEquals(numArmasInicial +1 ,
                numArmasInsertar, MESSAGE_ERROR);
        persistencia.deleteArma(armaInsertar);
        armas = persistencia.obtenerArmas();
        int numArmasBorrado = armas.size();
        Assertions.assertEquals(numArmasInicial ,
                numArmasBorrado,
                MESSAGE_ERROR);
    }

    @Test
    void actualizarArma() {
        String idActualizar = "MJ002";
        Arma armaBuscar = new Arma(idActualizar);
        Arma armaActualizar = persistencia.obtenerArma(armaBuscar);
        Arma armaBackup = persistencia.obtenerArma(armaBuscar);
        armaActualizar.setNombre("nombreActualizar");
        armaActualizar.setDescripcion("descripcionActualizar");
        persistencia.updateArma(armaActualizar);

        armaBuscar = persistencia.obtenerArma(armaBuscar);
        Assertions.assertEquals(armaBuscar.toString(), armaActualizar.toString(),
                MESSAGE_ERROR);
        persistencia.updateArma(armaBackup);
    }
}