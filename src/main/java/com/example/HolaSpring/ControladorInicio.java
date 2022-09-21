package com.example.HolaSpring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Slf4j
public class ControladorInicio {
    @Autowired
    private PersonaDAO personaDAO;

    @GetMapping("/")
    public String inicio(Model model) {
        var personas= personaDAO.findAll();
        log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("personas", personas);
        return "index";
    }

}
