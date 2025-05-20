package TP6_H071241029;
import java.util.Date;

public class Motor extends Kendaraan implements IBergerak, IServiceable {
    private String jenisMotor;
    private double kapasitasTangki;
    private String tipeSuspensi;
    private double kecepatan;

    public Motor(String merek, String model) {
        super(merek, model);
    }

    public String getJenisMotor() {
        return jenisMotor;
    }
    public void setJenisMotor(String jenis) {
        this.jenisMotor = jenis;
    }
    public double getKapasitasTangki() {
        return kapasitasTangki;
    }
    public void setKapasitasTangki(double kapasitas) {
        this.kapasitasTangki = kapasitas;
    }
    public String getTipeSuspensi() {
        return tipeSuspensi;
    }
    public void setTipeSuspensi(String tipe) {
        this.tipeSuspensi = tipe;
    }

    @Override
    public double hitungPajak() {
        return kapasitasTangki * 300_000;
    }
    @Override
    public String getTipeKendaraan() {
        return "Motor";
    }
    @Override
    public boolean mulai() {
        return true;
    }
    @Override
    public boolean berhenti() {
        kecepatan = 0;
        return true;
    }
    @Override
    public double getKecepatan() {
        return kecepatan;
    }
    @Override
    public void setKecepatan(double kecepatan) {
        this.kecepatan = kecepatan;
    }
    @Override
    public boolean periksaKondisi() {
        return true;
    }
    @Override
    public void lakukanServis() {
        System.out.println("Motor diservis.");
    }
    @Override
    public Date getWaktuServisBerikutnya() {
        return new Date();
    }
    @Override
    public double hitungBiayaServis() {
        return 500_000;
    }
}