package com.crud.rest.controller;

import com.crud.rest.models.entity.Persona;
import com.crud.rest.models.entity.Relacion;
import com.crud.rest.models.service.IPersonaService;
import com.crud.rest.models.service.IRelacionService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RelacionController {

    @Autowired
    IRelacionService relacionService;

    @Autowired
    IPersonaService personaService;

    @GetMapping("/relacion/{idPrimario}/{idSecundario}")
    public ResponseEntity<?> obtenerRelacion(@PathVariable() Long idPrimario, @PathVariable() Long idSecundario) {
        Map<String, Object> response = new HashMap<>();
        Persona persona = personaService.buscarPersonaPorId(idPrimario);
        Persona persona2 = personaService.buscarPersonaPorId(idSecundario);
        Relacion relaciones[] = new Relacion[4];

        relaciones[0] = relacionService.buscarRelacionPorId(persona.getRelaciones().getIdRelaciones());
        relaciones[1] = relacionService.buscarRelacionPorId(persona2.getRelaciones().getIdRelaciones());

        if (relaciones[0] != null && relaciones[1] != null) {
            relaciones[2] = relacionService.buscarRelacionAnterior(relaciones[0].getIdPrimario());
            relaciones[3] = relacionService.buscarRelacionAnterior(relaciones[1].getIdPrimario());
            if (relaciones[2] != null && relaciones[3] != null) {
                if (relaciones[2].getIdPrimario().equals(relaciones[3].getIdPrimario())) {
                    // existen relacion, podria ser primos o tios o hermanos
                    response.put("Relacion", "Hermano");
                } else {
                    response.put("Error", "No existe relacion");
                }
            } else {
                response.put("Error", "No existe relacion");
            }
        } else {
            response.put("Error", "No existe relacion");
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }


}
