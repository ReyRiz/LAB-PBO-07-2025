public class Main {
    public static void main(String[] args) {
        Mobil mobil = new Mobil("Toyota", "avanza");
        mobil.setJumlahPintu(4);
        mobil.setKapasitasMesin(1.5);
        mobil.setJumlahKursi(8);
        mobil.setBahanBakar("Bensin");
        mobil.setKecepatan(70);
        mobil.lakukanServis();

        Motor motor = new Motor("Honda", "Beat");
        motor.setJenisMotor("Matic");
        motor.setKapasitasTangki(5);
        motor.setTipeSuspensi("Telescopic");
        motor.setKecepatan(65);
        motor.lakukanServis();

        Sepeda sepeda = new Sepeda("Polygon", "Premier 5");
        sepeda.setJenisSepeda("Gunung");
        sepeda.setJumlahGear(21);
        sepeda.setUkuranRoda(27);
        sepeda.setKecepatan(20);
        sepeda.lakukanServis();

        Pesawat pesawat = new Pesawat("Airbus", "A330");
        pesawat.setJumlahMesin(2);
        pesawat.setPanjangSayap(35);
        pesawat.setKecepatan(850);
        pesawat.setPenerbanganDomestik(true);
        pesawat.lakukanServis();

        System.out.println("===DATA MOBIL===");
        System.out.println("Tipe: " + mobil.getTipeKendaraan());
        System.out.println("Pajak: Rp." + mobil.hitungPajak());
        System.out.println("Kecepatan: " + mobil.getKecepatan() + " Km/Jam");
        System.out.println("Waktu Servis Berikutnya: " + motor.getWaktuServisBerikutnya());
        System.out.println();

        System.out.println("===DATA MOTOR===");
        System.out.println("Tipe: " + motor.getTipeKendaraan());
        System.out.println("Pajak: Rp." + motor.hitungPajak());
        System.out.println("Kecepatan: " + motor.getKecepatan() + " Km/Jam");
        System.out.println("Waktu Servis Berikutnya: " + motor.getWaktuServisBerikutnya());
        System.out.println();

        System.out.println("===DATA SEPEDA===");
        System.out.println("Tipe: " + sepeda.getTipeKendaraan());
        System.out.println("Pajak: Rp." + sepeda.hitungPajak());
        System.out.println("Kecepatan: " + sepeda.getKecepatan() + " Km/Jam");
        System.out.println("Waktu Servis Berikutnya: " + sepeda.getWaktuServisBerikutnya());
        System.out.println();

        System.out.println("===DATA PESAWAT===");
        System.out.println("Tipe: " + pesawat.getTipeKendaraan());
        System.out.println("Pajak: Rp." + pesawat.hitungPajak());
        System.out.println("Kecepatan: " + pesawat.getKecepatan() + " Km/Jam");
        System.out.println("Waktu Servis Berikutnya: " + pesawat.getWaktuServisBerikutnya());
        System.out.println();
    }
}
