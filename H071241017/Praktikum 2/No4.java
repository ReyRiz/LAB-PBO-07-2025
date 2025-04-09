public class No4{
    public static void main(String[] args) {
        Alamat alamat = new Alamat();
        alamat.jalan = "Perintis Kemerdekaan 4";
        alamat.kota = "Makassar";

        Mahasiswa mahasiswa = new Mahasiswa("Julio","H071241017");
        mahasiswa.alamat = alamat;

        System.out.println("Nama: " + mahasiswa.getNama());
        System.out.println("Nim: " + mahasiswa.getNim());
        System.out.println("Alamat: " + mahasiswa.getAlamat());
    }
}

class Alamat{
    String jalan;
    String kota;
}

class Mahasiswa{
    String nama;
    String nim;
    Alamat alamat; //agar lebih singkat

    public Mahasiswa(String nama, String nim){
        this. nama = nama;
        this.nim = nim;
    }
    public String getNama(){
        return nama;
    }
    public String getNim(){
        return nim;
    }
    public String getAlamat() {
        return this.alamat.jalan + ", " + this.alamat.kota;
    }
}