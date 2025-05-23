package com.calendario.proyecto.backend.apirest.KEMLI.Cita;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;



@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class CitaController {
    @Autowired
    private CitaService citaService;

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

    @GetMapping("/citas/inactivas")
    public List<Cita> getFinalizadas() {
        return citaService.findFinished();
    }
    


    //CREAR UNA CITA
    @PreAuthorize("hasAnyAuthority('ROOT', 'ADMIN')")
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

    @PutMapping("/citas/estado/{id}")
    public ResponseEntity<?> changeCitaState(@PathVariable long id, @RequestBody CitaRequest body) {
        Map<String, Object> response = new HashMap<>();
        String message = "";
        HttpStatus status;
        
        if(body.estado == null || body == null) {
            message = "Error: Valor del estado vacío";
            status = HttpStatus.UNPROCESSABLE_ENTITY;
            response.put("mensaje", message);
            return new ResponseEntity<Map<String, Object>>(response, status); 
        }

        String estado = body.estado;

        try {
            citaService.changeCitaState(id, estado);
            message = "Estado de cita actualizado a ".concat(estado);
            response.put("mensaje", message);
        } catch(Exception e) {
            status = HttpStatus.BAD_REQUEST;
            response.put("mensaje", e.getMessage());
        }
        status = HttpStatus.OK;
        return new ResponseEntity<Map<String, Object>>(response, status); 
    }

    //ELIMINAR CITAS
    @PreAuthorize("hasAnyAuthority('ROOT', 'ADMIN')")
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