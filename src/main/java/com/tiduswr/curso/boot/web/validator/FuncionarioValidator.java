package com.tiduswr.curso.boot.web.validator;

import com.tiduswr.curso.boot.domain.Funcionario;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

public class FuncionarioValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Funcionario.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors e) {
        Funcionario f = (Funcionario) o;

        LocalDate entrada = f.getDataEntrada();
        LocalDate saida = f.getDataSaida();

        if(saida != null){
            if(saida.isBefore(entrada)){
                e.rejectValue("dataSaida","PosteriorDataEntrada.funcionario.dataSaida");
            }
        }

    }
}
