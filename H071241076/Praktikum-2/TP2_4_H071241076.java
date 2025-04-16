class Alamat {
    String jalan;
    String kota;

    public String toString() {
        return jalan + ", " + kota;
    }
}

class Mahasiswa {
    String nama;
    String nim;
    Alamat alamat;

    String getNama() {
        return nama;
    }

    String getNim() {
        return nim;
    }

    String getAlamat() {
        return alamat.toString();
    }
}

public class Soal4 {
    public static void main(String[] args) {
        Alamat alamat = new Alamat();
        alamat.jalan = "Perintis";
        alamat.kota = "Makassar";

        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.alamat = alamat;
        mahasiswa.nama = "Akram Alfadli Tamir";
        mahasiswa.nim = "H071241076";

        System.out.println("Nama: " + mahasiswa.getNama());
        System.out.println("Nim: " + mahasiswa.getNim());
        System.out.println("Alamat: " + mahasiswa.getAlamat());
        System.out.println(mahasiswa.alamat.jalan);
    
    }
}