public class no3{
    public static void main(String[] args) {
        Cuboid cuboid = new Cuboid();

        cuboid.height = 15;
        cuboid.weight = 10;
        cuboid.length = 30;

        System.out.printf("Volume = %.2f", cuboid.getVolume());

    }
}
