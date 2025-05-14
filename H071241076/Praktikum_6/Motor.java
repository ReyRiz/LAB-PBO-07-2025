import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Motor extends Kendaraan implements IBergerak, IServiceable {
    private String jenisMotor;
    private double kapasitasTangki;
    private String tipeSuspensi;
    private double kecepatan;
    private boolean mulai;
    private boolean berhenti;

    public Motor(String merek, String model) {
        super(merek, model);
    }

    public String getJenisMotor() {
        return jenisMotor;
    }

    public void setJenisMotor(String jenisMotor) {
        this.jenisMotor = jenisMotor;
    }

    public double getKapasitasTangki() {
        return kapasitasTangki;
    }

    public void setKapasitasTangki(double kapasitasTangki) {
        this.kapasitasTangki = kapasitasTangki;
    }

    public String getTipeSuspensi() {
        return tipeSuspensi;
    }

    public void setTipeSuspensi(String tipeSuspensi) {
        this.tipeSuspensi = tipeSuspensi;
    }

    @Override
    public boolean mulai() {
        mulai = true;
        berhenti = false;
        System.out.println("Motor dinyalakan.");
        return true;
    }

    @Override
    public boolean berhenti() {
        berhenti = true;
        mulai = false;
        kecepatan = 0;
        System.out.println("Motor dimatikan.");
        return true;
    }

    @Override
    public double getKecepatan() {
        return kecepatan;
    }

    @Override
    public void setKecepatan(double kecepatan) {
        if (mulai) {
            this.kecepatan = kecepatan;
            System.out.println("Kecepatan motor disetel ke " + kecepatan + " km/h.");
        } else {
            System.out.println("Motor harus dinyalakan terlebih dahulu.");
        }
    }

    @Override
    public boolean periksaKondisi() {
        boolean kondisi = kapasitasTangki > 2.0 && tipeSuspensi != null;
        System.out.println("Pemeriksaan motor: " + (kondisi ? "Layak jalan" : "Perlu servis"));
        return kondisi;
    }

    @Override
    public void lakukanServis() {
        System.out.println("Servis motor: ganti oli, cek rem, cek rantai.");
    }

    @Override
    public Date getWaktuServisBerikutnya() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 3);
        return cal.getTime();
    }

    @Override
    public double hitungBiayaServis() {
        double biaya = 250_000 + kapasitasTangki * 50_000;
        System.out.println("Biaya servis: " + formatRupiah(biaya));
        return biaya;
    }

    @Override
    public double hitungPajak() {
        double pajak = kapasitasTangki * 300_000;
        System.out.println("Pajak motor: " + formatRupiah(pajak));
        return pajak;
    }

    @Override
    public String getTipeKendaraan() {
        return "Motor";
    }

    private String formatRupiah(double nominal) {
        return NumberFormat.getCurrencyInstance(new Locale("in", "ID")).format(nominal);
    }
}
