package TP3_H071241029;

public class MainHunter {
    public static void main(String[] args) {
        // Evol evol1 = new Evol("Resonance", 100);
        Evol evol1 = new Evol();
        evol1.jenisEvol= "ccc";
        System.out.println(evol1.jenisEvol);
        Evol evol2 = new Evol("Mist", 200);

        Hunter hunter1 = new Hunter(); //default
        //"Adaire", "H001", evol1, true
        Hunter hunter2 = new Hunter("Tara", "H002", evol2, false);

        Wanderer w1 = new Wanderer("Arbiterwings", 1000);

        hunter1.secretAgent();
        hunter2.secretAgent();

        System.out.println("\n=== Serangan Individu ===");
        hunter1.memukul(w1);

        System.out.println("\n=== Serangan Bersama ===");
        hunter1.keroyok(w1, hunter2);
    }
}
