package TP4_no1_H071241029.models;

public class Profile {
    /*
     * TODO:
     * Tambahkan attribute, method, atau constructor
     * yang dibutuhkan di kelas user
     */

    private String fullName;
    private String nickName;
    private int age;
    private String hobby;

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
    public String getFullName() {
        return fullName;
    }
    public String getNickName() {
        return nickName;
    }
    public int getAge() {
        return age;
    }
    public String getHobby() {
        return hobby;
    }
}
