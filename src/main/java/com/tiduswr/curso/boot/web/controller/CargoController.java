package com.tiduswr.curso.boot.web.controller;

import com.tiduswr.curso.boot.domain.Cargo;
import com.tiduswr.curso.boot.domain.Departamento;
import com.tiduswr.curso.boot.service.CargoService;
import com.tiduswr.curso.boot.service.DepartamentoService;
import com.tiduswr.curso.boot.util.PaginacaoUTIL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cargos")
public class CargoController {

    @Autowired
    private CargoService cargoService;
    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping("/cadastrar")
    public String cadastrar(Cargo cargo){
        return "cargo/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap map, @RequestParam("page") Optional<Integer> page,
                         @RequestParam("dir") Optional<String> dir){

        int currentPage = page.orElse(1);
        String ordem = dir.orElse("ASC");
        PaginacaoUTIL<Cargo> pageCargo = cargoService.buscarPorPagina(5, currentPage, ordem);

        map.addAttribute("pageCargo", pageCargo);
        return "cargo/lista";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Cargo cargo, BindingResult result, RedirectAttributes attr){

        if(result.hasErrors()) return "cargo/cadastro";

        cargoService.salvar(cargo);
        attr.addFlashAttribute("success", "Cargo inserido com sucesso!");
        return "redirect:/cargos/cadastrar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable Long id, ModelMap map){
        map.addAttribute("cargo", cargoService.buscarPorId(id));
        return "cargo/cadastro";
    }

    @PostMapping("/editar")
    public String editar(@Valid Cargo cargo, BindingResult result, RedirectAttributes attr){

        if(result.hasErrors()) return "cargo/cadastro";

        cargoService.editar(cargo);
        attr.addFlashAttribute("success", "O cargo foi inserido com Sucesso!");
        return "redirect:/cargos/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr){
        if(cargoService.cargoTemFuncionario(id)){
            attr.addFlashAttribute("fail",
                    "Cargo não excluido pois possui funcionario(s) vinculado(s)!");
        }else{
            cargoService.excluir(id);
            attr.addFlashAttribute("success", "Cargo excluido com sucesso!");
        }
        return "redirect:/cargos/listar";
    }

    @ModelAttribute("departamentos")
    public List<Departamento> listaDeDepartamentos(){
        return departamentoService.buscarTodos();
    }

}
