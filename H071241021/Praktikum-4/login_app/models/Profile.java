package login_app.models;

public class Profile {
    /*
     * TODO:
     * Tambahkan attribute, method, atau constructor
     * yang dibutuhkan di kelas user
     */

    public User user;
    public String hobby, fullName, nickName;
    public int age;

    public Profile(User user){
        this.user = user;
    }

}
