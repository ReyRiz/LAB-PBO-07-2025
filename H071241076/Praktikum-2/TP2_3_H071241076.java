class Cuboid {
    double height;
    double width;
    double length;

    double getVolume() {
        // Lengkapi
        return height * width * length;
    }
}

public class Soal3 {
    public static void main(String[] args) {
        Cuboid cuboid = new Cuboid();
        // Lengkapi
        cuboid.height = 10;
        cuboid.width = 5;
        cuboid.length = 90;

        System.out.println(String.format("Volume = %.2f", cuboid.getVolume()));
    }
}