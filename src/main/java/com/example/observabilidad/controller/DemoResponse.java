package com.example.observabilidad.controller;

public class DemoResponse {
    private String mensaje;
    private long timestamp;

    public DemoResponse() {}

    public DemoResponse(String mensaje, long timestamp) {
        this.mensaje = mensaje;
        this.timestamp = timestamp;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
