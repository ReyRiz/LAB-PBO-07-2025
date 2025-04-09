class Cuboid {
    double tinggi;
    double lebar;
    double panjang;

    Cuboid() {
        tinggi = 15; 
        lebar = 10;  
        panjang = 30; 
    }

    double getVolume() {
       return tinggi * lebar * panjang; 
    }
}

public class No3 {
    public static void main(String[] args) {
        Cuboid cuboid = new Cuboid();
        System.out.println(String.format("Volume = %.4f", cuboid.getVolume()));
    }
}