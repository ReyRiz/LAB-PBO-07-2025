import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Kendaraan> daftarKendaraan = new ArrayList<>();

        // Mobil
        Mobil mobil = new Mobil("Toyota", "Avanza");
        mobil.setKapasitasMesin(1.5);
        mobil.setBahanBakar("Bensin");
        daftarKendaraan.add(mobil);

        // Motor
        Motor motor = new Motor("Honda", "Vario");
        motor.setKapasitasTangki(0.125);
        daftarKendaraan.add(motor);

        // Sepeda
        Sepeda sepeda = new Sepeda("Polygon", "Monarch");
        daftarKendaraan.add(sepeda);

        // Sepeda Listrik
        SepedaListrik sepedaListrik = new SepedaListrik("Xiaomi", "Himo Z20");
        sepedaListrik.setKapasitasBaterai(10.0);
        sepedaListrik.isiBaterai();
        daftarKendaraan.add(sepedaListrik);


        for (Kendaraan k : daftarKendaraan) {
            System.out.println("====================================");
            System.out.println("Tipe Kendaraan : " + k.getTipeKendaraan());
            System.out.println("Merek          : " + k.getMerek());
            System.out.println("Model          : " + k.getModel());

            if (k instanceof IBergerak) {
                IBergerak bergerak = (IBergerak) k;
                bergerak.mulai();
                bergerak.setKecepatan(30);
                System.out.println("Kecepatan      : " + bergerak.getKecepatan() + " km/h");
                bergerak.berhenti();
            }

            if (k instanceof IServiceable) {
                IServiceable service = (IServiceable) k;
                service.periksaKondisi();
                service.lakukanServis();
                service.hitungBiayaServis();
                System.out.println("Servis berikutnya pada: " + service.getWaktuServisBerikutnya());
            }

            System.out.println("Pajak Kendaraan: " + k.hitungPajak());
        }

        System.out.println("====================================");
        System.out.println("Selesai menampilkan seluruh kendaraan.");
    }
}
