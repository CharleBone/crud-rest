package com.crud.rest.controller;

import com.crud.rest.models.entity.Persona;
import com.crud.rest.models.entity.Relacion;
import com.crud.rest.models.service.IPersonaService;
import com.crud.rest.models.service.IRelacionService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RelacionController {

    @Autowired
    IRelacionService relacionService;

    @Autowired
    IPersonaService personaService;

    @GetMapping("/relacion/{idPrimario}/{idSecundario}")
    public String obtenerRelacion(@PathVariable() Long idPrimario, @PathVariable() Long idSecundario) {
        Persona persona = personaService.buscarPersonaPorId(idPrimario);
        Persona persona2 = personaService.buscarPersonaPorId(idSecundario);
        String mensaje = "";
        Relacion relacion = null;
        Relacion relacion2 = null;
        Relacion relacion3 = null;
        Relacion relacion4 = null;
        /*
        if (persona.getRelaciones().getIdRelaciones().equals(persona2.getRelaciones().getIdRelaciones())) {
            relacion = relacionService.buscarRelacionPorId(persona.getRelaciones().getIdPrimario());
            if (relacion != null) {
                mensaje = "Padre:".concat(relacion.getIdPrimario().toString()).concat(" e Hijo : ").concat(relacion.getIdSecundario().toString());
            }
        } else {

        }

         */

        relacion = relacionService.buscarRelacionPorId(persona.getRelaciones().getIdRelaciones());
        relacion2 = relacionService.buscarRelacionPorId(persona2.getRelaciones().getIdRelaciones());
        if (relacion != null & relacion2 != null) {
            List<Relacion> relaciones = relacionService.buscarRelaciones();
            for (Relacion r : relaciones) {
                if (r.getIdSecundario().equals(relacion.getIdPrimario())) {
                    relacion3 = relacionService.buscarRelacionPorId(r.getIdRelaciones());
                }
            }

            for (Relacion r : relaciones) {
                if (r.getIdSecundario().equals(relacion2.getIdPrimario())) {
                    relacion4 = relacionService.buscarRelacionPorId(r.getIdRelaciones());
                }
            }
            if (relacion3 != null & relacion4 != null) {
                if (relacion3.getIdPrimario().equals(relacion4.getIdPrimario())) {
                    // existen relacion, podria ser primos o tios o hermanos
                    mensaje =  "Hermanos:".concat(relacion3.getIdSecundario().toString()).concat(" e : ").concat(relacion4.getIdSecundario().toString());
                    mensaje += " Tio ";
                    mensaje += " Primos ";
                } else {
                    mensaje = "No existe relacion";
                }
            } else {
                mensaje = "No existe relacion";
            }

        } else {
            mensaje = "No existe relacion";
        }
        return mensaje;
    }


}
