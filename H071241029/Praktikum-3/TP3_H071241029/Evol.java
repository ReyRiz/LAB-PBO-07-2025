package TP3_H071241029;

public class Evol {
    protected String jenisEvol;
    protected int kekuatan;

    public Evol() {
        this.jenisEvol = "Combat";
        this.kekuatan = 100;
    }

    public Evol(String jenisEvol, int kekuatan) {
        this.jenisEvol = jenisEvol;
        this.kekuatan = kekuatan;
    }

    public int getKekuatan() {
        return kekuatan;
    }

    public String getJenisEvol() {
        return jenisEvol;
    }

    public void tampilkanEvol() {
        System.out.println("Jenis Evol: " + jenisEvol + ", Kekuatan: " + kekuatan);
    }
}
