//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
//Daniel Pozo Marques

import java.io.Serializable;

public class Contenedor implements Serializable {
    private int itentificador;
    private int prioridad;
    private double peso;
    private String paísProcedencia;
    private String descripción;
    private String empresaEmisora;
    private String empresaReceptora;
    private boolean aduana=false;

    public Contenedor(int itentificador, int prioridad, double peso, String paísProcedencia, String descripción, String empresaEmisora, String empresaReceptora) {
        this.itentificador = itentificador;
        if (prioridad >= 0 && prioridad <= 3) {
            this.prioridad = prioridad;
        }

        if (peso >= 1.0) {
            this.peso = peso;
        }

        this.paísProcedencia = paísProcedencia;
        if (descripción.length() <= 100) {
            this.descripción = descripción;
        }

        if (empresaEmisora.length() <= 20) {
            this.empresaEmisora = empresaEmisora;
        }

        if (empresaReceptora.length() <= 20) {
            this.empresaReceptora = empresaReceptora;
        }

    }

    public int getItentificador() {
        return this.itentificador;
    }

    public int getPrioridad() {
        return this.prioridad;
    }

    public double getPeso() {
        return this.peso;
    }

    public void setPeso(double peso) {
        if (peso >= 1.0) {
            this.peso = peso;
        }

    }

    public String getPaísProcedencia() {
        return this.paísProcedencia;
    }

    public void setPaísProcedencia(String paísProcedencia) {
        this.paísProcedencia = paísProcedencia;
    }

    public String getDescripción() {
        return this.descripción;
    }

    public void setDescripción(String descripción) {
        if (descripción.length() <= 100) {
            this.descripción = descripción;
        }

    }

    public String getEmpresaEmisora() {
        return this.empresaEmisora;
    }

    public void setEmpresaEmisora(String empresaEmisora) {
        if (empresaEmisora.length() <= 20) {
            this.empresaEmisora = empresaEmisora;
        }

    }

    public String getEmpresaReceptora() {
        return this.empresaReceptora;
    }

    public void setEmpresaReceptora(String empresaReceptora) {
        if (empresaReceptora.length() <= 20) {
            this.empresaReceptora = this.empresaEmisora;
        }

    }

    public boolean getAduana() {
        return aduana;
    }

    public void setAduana(boolean aduana) {
        this.aduana = aduana;
    }
}
