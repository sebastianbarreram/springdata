package com.example.HolaSpring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@Slf4j
public class ControladorInicio {
    @Value("${index.mensaje}")
    private String mensajeApplicacionProperties;

    @GetMapping("/")
    public String inicio(Model model) {
        var mensaje = "Mensaje con Thymeleaf";

        var persona = new Persona();
        persona.setNombre("Seb");
        persona.setApellido("Bar");
        persona.setEmail("s@s.com");
        persona.setTelefono("3");

        var persona2 = new Persona();
        persona2.setNombre("San");
        persona2.setApellido("Bar");
        persona2.setEmail("sa@s.com");
        persona2.setTelefono("2");

//        Otra forma de hacer lo mismo
//        List<Persona> personas= new ArrayList<>();
//        personas.add(persona);
//        personas.add(persona2);

        List<Persona> personas = Arrays.asList(persona, persona2);
//            List<Persona> personas=new ArrayList<Persona>();

        log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("mensajeApplicacionProperties", mensajeApplicacionProperties);
        model.addAttribute("persona", persona);
        model.addAttribute("personas", personas);
        return "index";
    }

}
