import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Mobil extends Kendaraan implements IBergerak, IServiceable {
    private int jumlahPintu;
    private double kapasitasMesin;
    private int jumlahKursi;
    private String bahanBakar;
    private double kecepatan;
    private boolean mulai;
    private boolean berhenti;

    public Mobil(String merek, String model) {
        super(merek, model);
    }

    public int getJumlahPintu() {
        return jumlahPintu;
    }

    public void setJumlahPintu(int jumlahPintu) {
        this.jumlahPintu = jumlahPintu;
    }

    public double getKapasitasMesin() {
        return kapasitasMesin;
    }

    public void setKapasitasMesin(double kapasitasMesin) {
        this.kapasitasMesin = kapasitasMesin;
    }

    public int getJumlahKursi() {
        return jumlahKursi;
    }

    public void setJumlahKursi(int jumlahKursi) {
        this.jumlahKursi = jumlahKursi;
    }

    public String getBahanBakar() {
        return bahanBakar;
    }

    public void setBahanBakar(String bahanBakar) {
        this.bahanBakar = bahanBakar;
    }

    @Override
    public boolean mulai() {
        if (!mulai) {
            mulai = true;
            berhenti = false;
            System.out.println("Mobil dinyalakan.");
        }
        return true;
    }

    @Override
    public boolean berhenti() {
        if (!berhenti) {
            berhenti = true;
            mulai = false;
            kecepatan = 0;
            System.out.println("Mobil dihentikan.");
        }
        return true;
    }

    @Override
    public double getKecepatan() {
        return kecepatan;
    }

    @Override
    public void setKecepatan(double kecepatan) {
        if (mulai && !berhenti) {
            this.kecepatan = kecepatan;
            System.out.println("Kecepatan mobil disetel ke " + kecepatan + " km/h.");
        } else {
            System.out.println("Mobil harus dinyalakan terlebih dahulu.");
        }
    }

    @Override
    public boolean periksaKondisi() {
        boolean kondisi = kapasitasMesin > 1.0 && bahanBakar != null;
        System.out.println("Pemeriksaan kondisi mobil: " + (kondisi ? "Baik" : "Perlu servis"));
        return kondisi;
    }

    @Override
    public void lakukanServis() {
        System.out.println("Servis mobil: ganti oli, cek rem, periksa mesin.");
    }

    @Override
    public Date getWaktuServisBerikutnya() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 6);
        return cal.getTime();
    }

    @Override
    public double hitungBiayaServis() {
        double biaya = 500_000 + kapasitasMesin * 100_000;
        System.out.println("Biaya servis: " + formatRupiah(biaya));
        return biaya;
    }

    @Override
    public double hitungPajak() {
        double pajak = kapasitasMesin * 750_000;
        System.out.println("Pajak mobil: " + formatRupiah(pajak));
        return pajak;
    }

    @Override
    public String getTipeKendaraan() {
        return "Mobil";
    }

    private String formatRupiah(double nominal) {
        return NumberFormat.getCurrencyInstance(new Locale("in", "ID")).format(nominal);
    }
}
