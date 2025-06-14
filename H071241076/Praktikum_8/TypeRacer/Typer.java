package TypeRacer;

class Typer extends Thread {
    private String botName, wordsTyped;
    private double wpm;
    private TypeRacer typeRacer;
    private long startTime, endTime;

    public Typer(String botName, double wpm, TypeRacer typeRacer) {
        this.botName = botName;
        this.wpm = wpm;
        this.wordsTyped = "";
        this.typeRacer = typeRacer;
    }

    public void addWordsTyped(String newWordsTyped) {
        this.wordsTyped += newWordsTyped + " ";
    }

    public String getWordsTyped() {
        return wordsTyped.trim();
    }

    public String getBotName() {
        return botName;
    }

    public double getWpm() {
        return wpm;
    }

    public long getEndTime() {
        return endTime - startTime;
    }

    @Override
    public void run() {
        String[] wordsToType = typeRacer.getWordsToType().split(" ");
        
        // TODO (1): Menghitung waktu antar kata berdasarkan WPM
        double secondsPerWord = 60.0 / wpm;
        long howLongToType = (long) (secondsPerWord * 1000); // dalam milidetik

        startTime = System.currentTimeMillis();

        // TODO (2): Mengetik kata demi kata sesuai jeda waktu
        for (String word : wordsToType) {
            try {
                Thread.sleep(howLongToType);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            addWordsTyped(word);
        }

        addWordsTyped("(Selesai)");
        endTime = System.currentTimeMillis();

        // TODO (3): Simpan hasil ke daftar klasemen
        typeRacer.addResult(new Result(botName, getEndTime() / 1000.0)); // dalam detik
    }
}
