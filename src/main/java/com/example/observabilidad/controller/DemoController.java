package com.example.observabilidad.controller;

import io.micrometer.observation.ObservationRegistry;
import io.micrometer.tracing.Tracer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo")
public class DemoController {
    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);
    private final Tracer tracer;
    private final ObservationRegistry observationRegistry;

    public DemoController(Tracer tracer, ObservationRegistry observationRegistry) {
        this.tracer = tracer;
        this.observationRegistry = observationRegistry;
    }

    @GetMapping
    public String demoEndpoint() {
        var span = tracer.currentSpan();
        if (span != null) {
            span.tag("custom.tag", "demo-call");
            span.event("demo-request-received");
            logger.info("Procesando petición demo con observabilidad. TraceId: {}, SpanId: {}", 
                span.context().traceId(), 
                span.context().spanId());
        } else {
            logger.warn("No se encontró un span activo");
        }
        return "Demo OK - TraceId: " + (span != null ? span.context().traceId() : "no-trace") + 
               " | SpanId: " + (span != null ? span.context().spanId() : "no-span");
    }
}
