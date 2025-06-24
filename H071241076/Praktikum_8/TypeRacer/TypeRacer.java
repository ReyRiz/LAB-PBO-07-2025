package TypeRacer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class TypeRacer {
    private String wordsToType;
    private ArrayList<Typer> rareContestant = new ArrayList<>();
    private ArrayList<Result> raceStanding = new ArrayList<>();

    public String getWordsToType() {
        return wordsToType;
    }

    public ArrayList<Typer> getRareContestant() {
        return rareContestant;
    }

    private String[] wordsToTypeList = {
        "Di Bikini Bottom ada Spongebob Squarepants, dia memang keren suka main drumband",
        "Dia jadi koki masaknya krabby patty, menjalani hari hidup bersama Garry",
        "Ayo sama-sama sebutkan nama-nama makhluk dalam sana di Bikini Bottom jaya",
        "Namun ada juga namanya Patrick Star, walau dia cetar tapi hidupnya liar",
        "Tinggal dalam batu tapi suka membantu, sayang hanya satu otaknya itu buntu"
    };

    public void setNewWordsToType() {
        Random random = new Random();
        int angkaRandom = random.nextInt(wordsToTypeList.length);
        wordsToType = wordsToTypeList[angkaRandom];
    }

    // TODO (4): Menyimpan hasil ke daftar klasemen
    public synchronized void addResult(Result result) {
        raceStanding.add(result);
    }

    // TODO (5): Menampilkan klasemen akhir
    private void printRaceStanding() {
        System.out.println("\nKlasemen Akhir Type Racer");
        System.out.println("=========================\n");

        Collections.sort(raceStanding, Comparator.comparingDouble(Result::getFinishTime));
        int pos = 1;
        for (Result r : raceStanding) {
            System.out.println(pos++ + ". " + r.getName() + " = " + (int) r.getFinishTime() + " detik");
        }
    }

    // TODO (6): Memulai lomba dengan menjalankan semua thread
    public void startRace() {
        for (Typer t : rareContestant) {
            t.start();
        }
    }

    // TODO (7,8): Menampilkan progres setiap 2 detik sampai semua selesai
    public void displayRaceStandingPeriodically() throws InterruptedException {
        boolean raceFinished = false;
        while (!raceFinished) {
            Thread.sleep(2000); // setiap 2 detik
            System.out.println("\nTyping Progress...");
            System.out.println("==================");

            for (Typer t : rareContestant) {
                System.out.println(t.getBotName() + " => " + t.getWordsTyped());
            }

            // cek jika semua bot selesai
            raceFinished = raceStanding.size() == rareContestant.size();
        }

        printRaceStanding();
    }
}
