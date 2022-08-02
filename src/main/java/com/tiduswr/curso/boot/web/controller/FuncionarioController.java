package com.tiduswr.curso.boot.web.controller;

import com.tiduswr.curso.boot.domain.Cargo;
import com.tiduswr.curso.boot.domain.Funcionario;
import com.tiduswr.curso.boot.domain.UF;
import com.tiduswr.curso.boot.service.CargoService;
import com.tiduswr.curso.boot.service.FuncionarioService;
import com.tiduswr.curso.boot.web.validator.FuncionarioValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;
    @Autowired
    private CargoService cargoService;

    @InitBinder("funcionario")
    public void initBinder(WebDataBinder binder){
        binder.addValidators(new FuncionarioValidator());
    }

    @GetMapping("/cadastrar")
    public String cadastrar(Funcionario f){
        return "funcionario/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model){
        model.addAttribute("funcionarios", funcionarioService.buscarTodos());
        return "funcionario/lista";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap map){
        map.addAttribute("funcionario", funcionarioService.buscarPorId(id));
        return "funcionario/cadastro";
    }

    @PostMapping("/editar")
    public String editar(@Valid Funcionario f, BindingResult result, RedirectAttributes attr){
        if(result.hasErrors()) return "funcionario/cadastro";

        funcionarioService.editar(f);
        attr.addFlashAttribute("success", "O Funcionário foi editado com sucesso!");
        return "redirect:/funcionarios/listar";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Funcionario f, BindingResult result, RedirectAttributes attr){
        if(result.hasErrors()) return "funcionario/cadastro";

        funcionarioService.salvar(f);
        attr.addFlashAttribute("success", "O funcionário foi inserido com Sucesso!");
        return "redirect:/funcionarios/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr){
        funcionarioService.excluir(id);
        attr.addFlashAttribute("success", "Funcionário excluido com sucesso!");
        return "redirect:/funcionarios/listar";
    }

    @GetMapping("/buscar/nome")
    public String getPorNome(@RequestParam("nome") String nome, ModelMap map){
        map.addAttribute("funcionarios", funcionarioService.buscarPorNome(nome));
        return "funcionario/lista";
    }

    @GetMapping("/buscar/cargo")
    public String getPorCargo(@RequestParam("id") Long id, ModelMap map){
        map.addAttribute("funcionarios", funcionarioService.buscarPorCargo(id));
        return "funcionario/lista";
    }

    @GetMapping("/buscar/data")
    public String getPorDatas(@RequestParam(name = "entrada", required = false)
                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate entrada,
                              @RequestParam(name ="saida", required = false)
                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate saida,
                              ModelMap map){
        map.addAttribute("funcionarios", funcionarioService.buscarPorDatas(entrada, saida));
        return "funcionario/lista";
    }

    @ModelAttribute("cargos")
    public List<Cargo> getCargos(){
        return cargoService.buscarTodos();
    }

    @ModelAttribute("ufs")
    public UF[] getUFs(){
        return UF.values();
    }

}
