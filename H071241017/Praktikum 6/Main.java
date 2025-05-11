public class Main {
    public static void main (String[] args){

        Mobil mobil1 = new Mobil("Cacicu", "Terbang");
        mobil1.setKapasitasMesin(200);
        System.out.println("BALIK LAGI KESINI TANGGAL : " + mobil1.getWaktuServiceBerikutnya());
        System.out.println("PAJAK MOBIL INI : " + mobil1.hitungPajak());
    }
}
