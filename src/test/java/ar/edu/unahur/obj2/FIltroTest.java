package ar.edu.unahur.obj2;
import java.util.List;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.filters.FiltroIdioma;
import ar.edu.unahur.obj2.filters.FiltroInsular;
import ar.edu.unahur.obj2.filters.FiltroNombre;
import ar.edu.unahur.obj2.filters.FiltroPoblacion;
import ar.edu.unahur.obj2.filters.FiltroRegion;
import ar.edu.unahur.obj2.filters.IFiltro;
import ar.edu.unahur.obj2.model.Pais;
import ar.edu.unahur.obj2.service.IPaisService;
import ar.edu.unahur.obj2.service.PaisService;

public class FIltroTest {

    @Test
	void prueba() {
		IPaisService paisService = new PaisService();
        List<Pais> paises = paisService.getPaises();
        IFiltro filtro = new FiltroIdioma("Arabic");

        IFiltro filtro2 = new FiltroIdioma("Arabic").and(new FiltroIdioma("French"));
        //IFiltro filtro2 = filtro.and(new FiltroIdioma("French"));

        IFiltro filtro3 = new FiltroInsular();

        IFiltro filtro4 = filtro3.and(new FiltroIdioma("French"));
        //IFiltro filtro4 = filtro3.and(filtro2);

        IFiltro filtro5 = new FiltroPoblacion(10000000);

        IFiltro filtro6 = filtro5.and(new FiltroIdioma("Chinese"));

        IFiltro filtro7 = new FiltroRegion("Asia");

        IFiltro filtro8 = new FiltroNombre("Argentina");

        List<Pais> paisesFiltrados = paises.stream().filter(p -> filtro6.apply(p)).toList();

        System.out.println(paisesFiltrados);
    }
}