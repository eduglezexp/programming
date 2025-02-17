package es.ies.puerto.file.uno;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static utilidades.UtilClassTest.MESSAGE_ERROR;

class FileXmlCriaturaTest {
    Criatura criatura;
    FileXmlCriatura persistencia;

    List<Criatura> criaturas;

    @BeforeEach
void beforeEach() throws Exception {
        persistencia = new FileXmlCriatura();
        criaturas = persistencia.obtenerCriaturas();
        criatura = new Criatura();
    }

    @Test
void obtenerCriaturasTest() {
        Assertions.assertFalse(criaturas.isEmpty(),
                MESSAGE_ERROR);
        Assertions.assertEquals(5,criaturas.size(),
                MESSAGE_ERROR);
    }

    @Test
void obtenerCriaturaTest() {
        String idBuscar = "ID_ACTUALIZAR";
        Criatura critaturaBuscar = new Criatura(idBuscar);
        critaturaBuscar = persistencia.obtener(critaturaBuscar);
        Assertions.assertEquals(critaturaBuscar.getId(),"ID_BUSCAR",
                MESSAGE_ERROR);
        Assertions.assertNotNull(critaturaBuscar.getNombre(),
                MESSAGE_ERROR);
        Assertions.assertTrue (critaturaBuscar.getCategoria().equals("VALOR_COMPARAR"),
                MESSAGE_ERROR);
        Assertions.assertNotNull(critaturaBuscar.getDescripcion().equals("VALOR_COMPARAR"),
                MESSAGE_ERROR);
    }

    @Test
void addDeleteCriaturaTest() throws Exception {

        int numCriaturasInicial = criaturas.size();
        Criatura criaturaInsertar = new Criatura();

        persistencia.addCriatura(criaturaInsertar);
        criaturas = persistencia.obtenerCriaturas();
        int numCriaturasInsertar = criaturas.size();
        Assertions.assertTrue(criaturas.contains(criaturaInsertar),
                MESSAGE_ERROR);
        Assertions.assertEquals(numCriaturasInicial +1 ,
                numCriaturasInsertar, MESSAGE_ERROR);
        persistencia.deleteCriatura(criaturaInsertar);
        criaturas = persistencia.obtenerCriaturas();
        int numCritaturasBorrado = criaturas.size();
        Assertions.assertEquals(numCriaturasInicial ,
                numCritaturasBorrado,
                MESSAGE_ERROR);
    }

    @Test
void actualizarCriatura() throws Exception {
        String idActualizar = "DG001";
        Criatura CriaturaBuscar = new Criatura(idActualizar);
        Criatura CriaturaActualizar = persistencia.obtener(CriaturaBuscar);
        Criatura CriaturaBackup = persistencia.obtener(CriaturaBuscar);
        CriaturaActualizar.setNombre("nombreActualizar");
        CriaturaActualizar.setDescripcion("edadActualizar");
        CriaturaActualizar.setCategoria("emailActualizar");
        persistencia.updateCriatura(CriaturaActualizar);

        CriaturaBuscar = persistencia.obtener(CriaturaBuscar);
        Assertions.assertEquals(CriaturaBuscar.toString(), CriaturaActualizar.toString(),
                MESSAGE_ERROR);
        persistencia.updateCriatura(CriaturaBackup);

    }
}
