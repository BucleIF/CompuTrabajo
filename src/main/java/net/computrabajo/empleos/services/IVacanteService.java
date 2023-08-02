package net.computrabajo.empleos.services;

import java.util.List;

import net.computrabajo.empleos.model.Vacante;

public interface IVacanteService {

    List<Vacante> buscarTodas();

    Vacante buscarPorId(Integer idVacante);
    
}
