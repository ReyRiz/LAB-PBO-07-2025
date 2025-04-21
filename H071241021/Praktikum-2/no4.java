public class no4{
    public static void main(String[] args) {
        Alamat alamat = new Alamat();
        alamat.jalan = "Tamalanrea Indah";
        alamat.kota = "Makassar";

        Mahasiswa mahasiswa = new Mahasiswa();
        
        mahasiswa.alamat = alamat;
        mahasiswa.nama = "Raihan";
        mahasiswa.nim = "H071241021";

        System.out.printf("Nama : %s\n", mahasiswa.getName());
        System.out.printf("NIM : %s\n", mahasiswa.getNim());
        System.out.printf("Alamat : %s\n", mahasiswa.getAlamat());
    }
}

