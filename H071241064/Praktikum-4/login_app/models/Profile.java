package login_app.models;

public class Profile {
    private String fullName;
    private String nickName;
    private int age;
    private String hobby;

    public String getfullName() {
        return fullName;
    }

    public void setfullName(String fullName) {
        this.fullName = fullName;
    }

    public String getnickName() {
        return nickName;
    }

    public void setnickName(String nickName) {
        this.nickName = nickName;
    }

    public int getage() {
        return age;
    }

    public void setage(int age) {
        this.age = age;
    }

    public String gethobby() {
        return hobby;
    }

    public void sethobby(String hobby) {
        this.hobby = hobby;
    }

}