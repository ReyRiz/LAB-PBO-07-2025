package TP6_H071241029;
import java.util.Locale;
import java.text.SimpleDateFormat;
public class Main6 {
    public static void main(String[] args) {
        // Objek Mobil
        Mobil mobil = new Mobil("Toyota", "Avanza");
        mobil.setJumlahPintu(4);
        mobil.setKapasitasMesin(1.5);
        mobil.setJumlahKursi(7);
        mobil.setBahanBakar("Bensin");
        mobil.setKecepatan(100);

        System.out.println("=== Data Mobil ===");
        System.out.println("Tipe: " + mobil.getTipeKendaraan());
        System.out.println("Jumlah Pintu: " + mobil.getJumlahPintu());
        System.out.println("Kapasitas Mesin: " + mobil.getKapasitasMesin() + " L");
        System.out.println("Jumlah Kursi: " + mobil.getJumlahKursi());
        System.out.println("Bahan Bakar: " + mobil.getBahanBakar());
        System.out.println("Kecepatan: " + mobil.getKecepatan() + " km/jam");
        System.out.println("Pajak: Rp" + mobil.hitungPajak());
        System.out.println("Biaya Servis: Rp" + mobil.hitungBiayaServis());
        mobil.lakukanServis();
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy H:mm:ss", new Locale("id","ID"));
        String Formatting = formatter.format(mobil.getWaktuServisBerikutnya());
        System.out.println(Formatting);
        System.out.println();

        // Objek Motor
        Motor motor = new Motor("Honda", "Vario");
        motor.setJenisMotor("Skuter");
        motor.setKapasitasTangki(5);
        motor.setTipeSuspensi("Belakang");
        motor.setKecepatan(80);

        System.out.println("=== Data Motor ===");
        System.out.println("Tipe: " + motor.getTipeKendaraan());
        System.out.println("Jenis Motor: " + motor.getJenisMotor());
        System.out.println("Kapasitas Tangki: " + motor.getKapasitasTangki() + " L");
        System.out.println("Tipe Suspensi: " + motor.getTipeSuspensi());
        System.out.println("Kecepatan: " + motor.getKecepatan() + " km/jam");
        System.out.println("Pajak: Rp" + motor.hitungPajak());
        System.out.println("Biaya Servis: Rp" + motor.hitungBiayaServis());
        motor.lakukanServis();
        System.out.println();

        // Objek Sepeda
        Sepeda sepeda = new Sepeda("Polygon", "Premier 5");
        sepeda.setJenisSepeda("Gunung");
        sepeda.setJumlahGear(21);
        sepeda.setUkuranRoda(27);
        sepeda.setKecepatan(25);

        System.out.println("=== Data Sepeda ===");
        System.out.println("Tipe: " + sepeda.getTipeKendaraan());
        System.out.println("Jenis Sepeda: " + sepeda.getJenisSepeda());
        System.out.println("Jumlah Gear: " + sepeda.getJumlahGear());
        System.out.println("Ukuran Roda: " + sepeda.getUkuranRoda() + " inci");
        System.out.println("Kecepatan: " + sepeda.getKecepatan() + " km/jam");
        System.out.println("Pajak: Rp" + sepeda.hitungPajak());
        System.out.println("Biaya Servis: Rp" + sepeda.hitungBiayaServis());
        sepeda.lakukanServis();
        System.out.println();

        // objek Airjet
        Airjet jet = new Airjet("Superjet", "A350", 4, 64.75);


        System.out.println("=== DATA AIRJET ===");
        System.out.println("Merek: " + jet.getMerek());
        System.out.println("Model: " + jet.getModel());
        System.out.println("Tipe Kendaraan: " + jet.getTipeKendaraan());
        System.out.println("Jumlah Mesin: " + jet.getJumlahMesin());
        System.out.println("Panjang Sayap: " + jet.getPanjangSayap() + " meter");

        // Menyalakan jet
        boolean mulai = jet.mulai();
        System.out.println("Status mulai: " + mulai);
        // Mengatur dan menampilkan kecepatan
        jet.setKecepatan(900.0);
        System.out.println("Kecepatan saat ini: " + jet.getKecepatan() + " km/jam");
        // Menampilkan pajak
        System.out.println("Estimasi Pajak: Rp" + jet.hitungPajak());
        // Menghentikan jet
        boolean berhenti = jet.berhenti();
        System.out.println("Status berhenti: " + berhenti);
    }
}