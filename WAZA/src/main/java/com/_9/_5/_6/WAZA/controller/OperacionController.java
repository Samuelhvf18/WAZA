package com._9._5._6.WAZA.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com._9._5._6.WAZA.tools.Operacion;

@RestController
public class OperacionController {

    @PostMapping("/calcular")
    public String calcular(@RequestBody String expresion){

        String postfix = Operacion.convertirPostfix(expresion);

        return Operacion.resolver(postfix);
    }
}