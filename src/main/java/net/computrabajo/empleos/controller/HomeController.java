package net.computrabajo.empleos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



import java.util.Date;
import java.util.LinkedList;
import java.util.List;


import org.springframework.ui.Model;


import net.computrabajo.empleos.model.Vacante;
import net.computrabajo.empleos.services.IVacanteService;





@Controller
public class HomeController {

	@Autowired
	private IVacanteService ServiceVacante;


    @GetMapping("/tabla")
    public String mostrarTabla(Model model){
        List<Vacante> lista = ServiceVacante.buscarTodas();
        model.addAttribute("vacantes", lista);

        return "tabla";
    }

    @GetMapping("/detalle")
    public String mostrarDetalle(Model model){

        Vacante vacante = new Vacante();

        vacante.setNombre("Communications Engineer");
        vacante.setDescripcion("Engineer required to support internet");
        vacante.setFecha(new Date());
        vacante.setSalario(9700.0);

        model.addAttribute("vacante", vacante);
		
        return "detalle";

    }

    @GetMapping("/listado")
    public String mostrarListado(Model model){

        List<String> lista = new LinkedList<String>();
        lista.add("System Enginner");
        lista.add("Accounting clerk");
        lista.add("Seller");
        lista.add("Architect");

        model.addAttribute("empleos", lista);

        return "listado";
    }

    @GetMapping("/")
    public String mostrarHome(Model model) {
        /*model.addAttribute("mensaje", "Welcome to CompuTrabajo App");
        model.addAttribute("fecha", new Date()); */

        String nombre = "Auxiliar de contabilidad";
        Date fechaPub = new Date();
        double salario = 9000.0;
        boolean vigente = true;


        model.addAttribute("nombre", nombre);
        model.addAttribute("fecha", fechaPub);
        model.addAttribute("salario", salario);
        model.addAttribute("vigente", vigente);
        
        return "home";

    }

    
}