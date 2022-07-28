package com.tiduswr.curso.boot.web.conversor;

import com.tiduswr.curso.boot.domain.Departamento;
import com.tiduswr.curso.boot.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToDepartamentoConverter implements Converter<String, Departamento> {

    @Autowired
    private DepartamentoService s;

    @Override
    public Departamento convert(String source) {
        if(source.isEmpty()) return null;

        Long id = Long.valueOf(source);
        return s.buscarPorId(id);
    }
}
