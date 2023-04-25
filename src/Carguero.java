//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.Serializable;

public class Carguero implements Serializable {
    private Hub[] carguero = new Hub[3];

    public Carguero() {
        for(int i = 0; i < this.carguero.length; ++i) {
            this.carguero[i] = new Hub();
        }

    }

    public void apilarContenedor(Contenedor c) {
        boolean huecoTomado = false;
        if (this.carguero[0].Idduplicado(c) + this.carguero[1].Idduplicado(c) + this.carguero[2].Idduplicado(c) == 0) {
            for(int i = 0; i < 3 && !this.carguero[i].apilarContenedor(c); ++i) {
            }
        }

    }

    public Contenedor desapilarContenedor(int hub, int columna) {
        return hub > 0 && hub < 4 && columna > 0 && columna < 13 ? this.carguero[hub - 1].desapilarContenedor(columna) : null;
    }

    public Contenedor mostrarContenedor(int id) {
        for(int i = 0; i < this.carguero.length; ++i) {
            if (this.carguero[i].mostrarContenedor(id) != null) {
                return this.carguero[i].mostrarContenedor(id);
            }
        }

        return null;
    }

    public int contenedoresporPais(String pais) {
        int cantidad = 0;

        for(int i = 0; i < this.carguero.length; ++i) {
            cantidad += this.carguero[i].contenedoresPais(pais);
        }

        return cantidad;
    }

    public String toString(int hub) {
        return hub > 0 && hub < 4 ? this.carguero[hub - 1].toString() : null;
    }

    public String toString() {
        String s = "";

        for(int i = 0; i < this.carguero.length; ++i) {
            s = s + "Hub " + (i + 1) + ":\n" + this.carguero[i].toString();
        }

        return s;
    }

    public String PesoAduana(int hub, int peso){
        return hub > 0 && hub < 4 && peso>=0 ? this.carguero[hub - 1].PesoAduanas(peso) : null;
    }
}
