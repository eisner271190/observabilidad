package com.example.observabilidad.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/demo")
public class DemoController {

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    public DemoController() {}

    @PostMapping
    public DemoResponse demoPostEndpoint(@RequestBody DemoRequest requestBody) {
        logger.info("Procesando request para {}", requestBody.getNombre());

        // Simulación de procesamiento
        try {
            Thread.sleep(200); // Para ver latencia en la traza
        } catch (InterruptedException e) {
            logger.error("Error simulando latencia", e);
        }

        // Construir respuesta
        DemoResponse respuesta = new DemoResponse(
                "Hola " + requestBody.getNombre() + ", edad: " + requestBody.getEdad(),
                System.currentTimeMillis()
        );

        logger.info("Response generado para {}", requestBody.getNombre());

        return respuesta;
    }
}
