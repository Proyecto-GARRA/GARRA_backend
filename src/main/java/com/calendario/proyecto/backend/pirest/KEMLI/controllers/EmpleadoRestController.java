package com.calendario.proyecto.backend.pirest.KEMLI.controllers;

import com.calendario.proyecto.backend.pirest.KEMLI.models.entity.Cliente;
import com.calendario.proyecto.backend.pirest.KEMLI.models.entity.Empleado;
import com.calendario.proyecto.backend.pirest.KEMLI.models.entity.TipoDeEmpleado;
import com.calendario.proyecto.backend.pirest.KEMLI.models.services.Empleado.IEmpleadoService;
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
import java.util.stream.Collectors;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class EmpleadoRestController {
    @Autowired
    private IEmpleadoService empleadoService;

    @GetMapping("/empleados")
    public List<Empleado> index() {
        return empleadoService.findAll();
    }

    //OBTENER CLIENTES MEDIANTE ID
    @GetMapping("/empleados/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {
        Empleado empleado = null;

        Map<String, Object> response = new HashMap<>();

        try {
            empleado = empleadoService.findById(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al buscar al cliente en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (empleado == null) {
            response.put("mensaje", "El empleado ID:".concat(id.toString().concat("No existe en la base de datos")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Empleado>(empleado, HttpStatus.OK);
    }

    //CREAR UN EMPLEADO
    @PostMapping("/empleados")
    public ResponseEntity<?> create(@Valid @RequestBody Empleado empleado, BindingResult result) {
        Empleado empleadoNew = null;

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
            empleadoNew = empleadoService.save(empleado);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error en el insert en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "ha sido actualizado con exito");
        response.put("empleado", empleadoNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

    }

    @PutMapping("/empleados/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Empleado empleado, BindingResult result, @PathVariable Long id) {
        Empleado empleadoActual = empleadoService.findById(id);

        Empleado empleadoUpdate = null;

        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
        if (empleadoActual == null) {
            response.put("mensaje", "Error no se pudo editar, el empleado ID: ".concat(id.toString().concat("No existe en la base de datos")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            empleadoActual.setNombreDelEmpleado(empleado.getNombreDelEmpleado());
            empleadoActual.setApellido_P(empleado.getApellido_P());
            empleadoActual.setApellido_M(empleado.getApellido_M());
            empleadoActual.setDomicilio(empleado.getDomicilio());
            empleadoActual.setTelefono(empleado.getTelefono());
            empleadoActual.setCorreo(empleado.getCorreo());
            empleadoActual. setTipoDeEmpleado(empleado.getTipoDeEmpleado());

            empleadoUpdate = empleadoService.save(empleadoActual);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el cliente en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "ha sido actualizado con exito");
        response.put("empleado", empleadoUpdate);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/empleados/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        try {
            empleadoService.delete(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar el empleado en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El empleado ha sido eliminado con exito");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

    }

    //TIPO DE EMPLEADOS
    @GetMapping("/empleados/tipoEmpleados")
    public List<TipoDeEmpleado> listarTiposEmpleados() {
        return empleadoService.findAllTipoEmpleados();
    }

    //Busqueda de empleado
    @GetMapping("/empleados/filtrar-empleados/{termino}")
    @ResponseStatus(HttpStatus.OK)
    public List<Empleado> filtrarEmpleado(@PathVariable String termino) {
        return empleadoService.findPorNombre(termino);
    }

    @GetMapping("/empleados/filtrar-tecnicos")
    @ResponseStatus(HttpStatus.OK)
    public List<Empleado> filtrarTecnico (){
        return empleadoService.filtrarTecnico();
    }
}
