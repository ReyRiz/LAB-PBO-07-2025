public class Main {
    public static void main(String[] args) {
        Senjata mjolnir = new Senjata("Mjolnir", 25);
        Senjata shield = new Senjata("Vibranium Shield", 15);
        Senjata repulsor = new Senjata("Repulsor", 20);

        Avenger thor = new Avenger("Thor", 100, mjolnir);
        Avenger cap = new Avenger("Captain America", 100, shield);
        Avenger tony = new Avenger("Iron Man", 100, repulsor);

        System.out.println("--- STATUS AWAL ---");
        thor.status();
        cap.status();
        tony.status();
        System.out.println();

        thor.serang(tony);
        cap.serang(tony);
        System.out.println();

        tony.pulihkanDiri();
        System.out.println();

        thor.serang(tony);
        cap.serang(tony);
        System.out.println();

        tony.pulihkanDiri();

        System.out.println("\n--- STATUS AKHIR ---");
        thor.status();
        cap.status();
        tony.status();
    }
}

