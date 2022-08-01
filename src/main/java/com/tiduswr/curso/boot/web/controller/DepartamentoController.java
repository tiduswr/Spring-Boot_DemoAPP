package com.tiduswr.curso.boot.web.controller;

import com.tiduswr.curso.boot.domain.Departamento;
import com.tiduswr.curso.boot.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController{

    @Autowired
    private DepartamentoService service;

    @GetMapping("/cadastrar")
    public String cadastrar(Departamento d){
        return "/departamento/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model){
        List<Departamento> l = service.buscarTodos();
        if(l != null){
            l = l.stream()
                .sorted((o1, o2) -> o1.getId().compareTo(o2.getId()))
                .collect(Collectors.toList());
        }
        model.addAttribute("departamentos", l);
        return "/departamento/lista";
    }

    @PostMapping("/salvar")
    //RedirectAttribute é usado quando existe a palavra "redirect:"
    public String salvar(@Valid Departamento d, BindingResult result, RedirectAttributes attr){

        if(result.hasErrors()) return "/departamento/cadastro";

        service.salvar(d);
        attr.addFlashAttribute("success", "Departamento salvo com Sucesso!");
        return "redirect:/departamentos/cadastrar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("departamento", service.buscarPorId(id));
        return "/departamento/cadastro";
    }

    @PostMapping("/editar")
    public String editar(@Valid Departamento d, BindingResult result, RedirectAttributes attr){

        if(result.hasErrors()) return "/departamento/cadastro";

        service.editar(d);
        attr.addFlashAttribute("success", "Departamento editado com Sucesso!");
        return "redirect:/departamentos/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap modelMap){
        if(!service.departamentoPossuiCargo(id)){
            service.excluir(id);
            modelMap.addAttribute("success",
                    "Departamento excluido com sucesso!");
        }else{
            modelMap.addAttribute("fail",
                    "Departamento não removido. Possui cargos vinculado(s)!");
        }
        return listar(modelMap);
    }

}
