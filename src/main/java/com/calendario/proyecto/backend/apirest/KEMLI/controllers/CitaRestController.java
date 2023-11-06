package com.calendario.proyecto.backend.apirest.KEMLI.controllers;

import com.calendario.proyecto.backend.apirest.KEMLI.models.entity.Cita;
import com.calendario.proyecto.backend.apirest.KEMLI.models.entity.TipoDeActividad;
import com.calendario.proyecto.backend.apirest.KEMLI.models.entity.TipoDeEmpleado;
import com.calendario.proyecto.backend.apirest.KEMLI.models.services.Cita.ICitaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class CitaRestController {
    @Autowired
    private ICitaService citaService;

    @GetMapping ("/citas")
    public List<Cita> index(){
        return citaService.findAll();
    }

    @GetMapping("/citas/{id}")
    public ResponseEntity<?> busquedaPorId(@PathVariable Long id){
        Cita cita = null;

        Map<String, Object> response = new HashMap<>();

        try{
            cita = citaService.findById(id);
        } catch (DataAccessException e){
            response.put("mensaje", "Error al realizar la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (cita == null){
            response.put("mensaje", "La cita ID: ".concat(id.toString().concat("No existe en la base de datos")));
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Cita>(cita, HttpStatus.OK);
    }


    //CREAR UNA CITA
    @PostMapping("/citas")
    public ResponseEntity<?> create (@Valid @RequestBody Cita cita, BindingResult result){
        Cita citaNew = null;

        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {

            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
        try {
            citaNew = citaService.save(cita);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error en el insert en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "ha sido agregado con exito");
        response.put("cliente", citaNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    //MODIFICAR CITA
    @PutMapping("/citas/{id}")
    public ResponseEntity<?> update (@Valid @RequestBody Cita cita, BindingResult result, @PathVariable Long id){
        Cita citaActual = citaService.findById(id);
        Cita citaUpdate = null;

        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        if (citaActual == null) {
            response.put("mensaje", "Error no se pudo editar, la cita ID: ".concat(id.toString().concat(" No existe en la base de datos")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            citaActual.setEmpleado(cita.getEmpleado());
            citaActual.setCliente(cita.getCliente());
            citaActual.setTipoDeActividad(cita.getTipoDeActividad());
            citaActual.setFecha_cita(cita.getFecha_cita());
            citaActual.setHora_cita(cita.getHora_cita());
            citaActual.setDireccion(cita.getDireccion());
            citaActual.setDescripcion(cita.getDescripcion());

            citaUpdate = citaService.save(citaActual);
        } catch (DataAccessException e) {
        response.put("mensaje", "Error al actualizar la cita en la base de datos");
        response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
        response.put("mensaje", "ha sido actualizado con exito");
        response.put("cliente", citaActual);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/citas/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        try {
            citaService.delete(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar la cita en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "La cita ha sido eliminado con exito");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    //TIPO DE ACTIVIDAD
    @GetMapping("/citas/tipoActividades")
    public List<TipoDeActividad> listarTiposActividades() {
        return citaService.findAllTipoActividades();
    }

    @GetMapping("citas/filtrar-cliente-citas/{termino}")
    @ResponseStatus(HttpStatus.OK)
    public List<Cita> filtrarClientes(@PathVariable String termino){
        return citaService.filtradoDeNombreCliente(termino);
    }


    @GetMapping("citas/filtrar-empleado-citas/{termino_nombre_empleado}")
    @ResponseStatus(HttpStatus.OK)
    public  List<Cita> filtrarEmpleados(@PathVariable String termino_nombre_empleado){
        return citaService.filtradoDeNombreEmpleado(termino_nombre_empleado);
    }
}
