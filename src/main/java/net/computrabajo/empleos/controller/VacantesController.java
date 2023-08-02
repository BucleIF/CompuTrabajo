package net.computrabajo.empleos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.computrabajo.empleos.model.Vacante;
import net.computrabajo.empleos.services.IVacanteService;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {

    @Autowired
    private IVacanteService ServiceVacante;
    
    @GetMapping("/delete")
    public String eliminar(@RequestParam("id") int idVacante, Model model) {

        System.out.println("Borrando Vacante con id: " + idVacante);
        model.addAttribute("id", idVacante);
        return "mensaje";

    }

    @GetMapping("/view/{id}")
    public String verDetalle(@PathVariable("id") int idVacante, Model model){

        Vacante vacante = ServiceVacante.buscarPorId(idVacante);

        System.out.println("Vacante: " + vacante);
        model.addAttribute("vacante", vacante);
        return "detalle";
    }
}
