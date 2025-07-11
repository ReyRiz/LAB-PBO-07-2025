package TypeRacer;

class Result {
    private String name;
    private int finishTime;

    public Result(String name, double finishTime) {
        this.name = name;
        this.finishTime = (int) finishTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }
}