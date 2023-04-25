//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
//Daniel Pozo Marques

import java.io.Serializable;

public class Hub implements Serializable {
    private Contenedor[][] complex = new Contenedor[10][12];
    private byte[] libresPrioridad = new byte[3];

    public Hub() {
        this.libresPrioridad[0] = 10;
        this.libresPrioridad[1] = 10;
        this.libresPrioridad[2] = 100;
     }

    public int Idduplicado(Contenedor c) {
        for(int j = 0; j < 12; ++j) {
            for(int k = 9; k >= 0; --k) {
                if (this.complex[k][j] != null && this.complex[k][j].getItentificador() == c.getItentificador()) {
                    return 1;
                }
            }
        }

        return 0;
    }

    public boolean apilarContenedor(Contenedor c) {
        int i;
        if (c.getPrioridad() > 0 && c.getPrioridad() < 3 && this.libresPrioridad[c.getPrioridad() - 1] != 0 && this.Idduplicado(c) != 1) {
            for(i = 9; i >= 0; --i) {
                if (this.complex[i][c.getPrioridad() - 1] == null) {
                    this.complex[i][c.getPrioridad() - 1] = c;
                    --this.libresPrioridad[c.getPrioridad() - 1];
                    return true;
                }
            }
        } else if (c.getPrioridad() == 3 && this.libresPrioridad[2] != 0 && this.Idduplicado(c) != 1) {
            for(i = 2; i < 12; ++i) {
                for(int j = 9; j >= 0; --j) {
                    if (this.complex[j][i] == null) {
                        this.complex[j][i] = c;
                        --this.libresPrioridad[2];
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public Contenedor desapilarContenedor(int columna) {
        Contenedor c = null;
        int i;
        if (columna >= 0 && columna < 3 && this.libresPrioridad[columna - 1] != 10) {
            for(i = 0; i < 10; ++i) {
                if (this.complex[i][columna - 1] != null) {
                    c = this.complex[i][columna - 1];
                    this.complex[i][columna - 1] = null;
                    ++this.libresPrioridad[columna - 1];
                    break;
                }
            }
        }

        if (columna >= 2 && columna < 13 && this.libresPrioridad[2] != 100) {
            for(i = 0; i < 10; ++i) {
                if (this.complex[i][columna - 1] != null) {
                    c = this.complex[i][columna - 1];
                    this.complex[i][columna - 1] = null;
                    ++this.libresPrioridad[2];
                    return c;
                }
            }
        }

        return c;
    }

    public String toString() {
        String s = "";

        for(int i = 0; i < 10; ++i) {
            for(int j = 0; j < 12; ++j) {
                if (this.complex[i][j] == null) {
                    s = s + "[_] ";
                } else {
                    if (this.complex[i][j].getPrioridad() == 1) {
                        s = s + "[1] ";
                    }

                    if (this.complex[i][j].getPrioridad() == 2) {
                        s = s + "[2] ";
                    }

                    if (this.complex[i][j].getPrioridad() == 3) {
                        s = s + "[3] ";
                    }
                }
            }

            s = s + "\n";
        }

        return s;
    }

    public Contenedor mostrarContenedor(int id) {
        boolean presente = false;

        for(int i = 0; i < 10; ++i) {
            for(int j = 0; j < 12; ++j) {
                if (this.complex[i][j] != null && this.complex[i][j].getItentificador() == id) {
                    return this.complex[i][j];
                }
            }
        }

        return null;
    }

    public int contenedoresPais(String país) {
        int cantidad = 0;

        for(int i = 0; i < 10; ++i) {
            for(int j = 0; j < 12; ++j) {
                if (this.complex[i][j] != null && this.complex[i][j].getPaísProcedencia().equals(país)) {
                    ++cantidad;
                }
            }
        }

        return cantidad;
    }

    public String PesoAduanas(int peso){
        String a = " ";
        for(int i = 0; i < 10; ++i) {
            for(int j = 0; j < 12; ++j) {
                if (this.complex[i][j] != null && this.complex[i][j].getPeso()==peso) {
                    this.complex[i][j].setAduana(true);
                    a = a +" El contenedor [" +i +"] ["+ j + "] Id: " + this.complex[i][j].getItentificador() + ", Remintente: " + this.complex[i][j].getEmpresaReceptora() + ", Peso: " + this.complex[i][j].getPeso() + " Aduana: " +this.complex[i][j].getAduana()+" .";
                }
            }
        }
        return a;
    }
}
