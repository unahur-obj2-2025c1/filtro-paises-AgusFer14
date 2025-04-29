package ar.edu.unahur.obj2.filters;

import ar.edu.unahur.obj2.model.Pais;

public class FiltroInsular extends Filtro{

    @Override
    public Boolean apply(Pais pais) {
        return pais.esIsla();
    }
    
}
