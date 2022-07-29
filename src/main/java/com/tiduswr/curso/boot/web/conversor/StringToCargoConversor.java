package com.tiduswr.curso.boot.web.conversor;

import com.tiduswr.curso.boot.domain.Cargo;
import com.tiduswr.curso.boot.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToCargoConversor implements Converter<String, Cargo> {

    @Autowired
    private CargoService s;

    @Override
    public Cargo convert(String source) {
        if(source.isEmpty()) return null;
        Long id = Long.valueOf(source);
        return s.buscarPorId(id);
    }
}
