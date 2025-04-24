package TP4_no1_H071241029;
import java.util.ArrayList;
import java.util.Scanner;
import TP4_no1_H071241029.models.Profile;
import TP4_no1_H071241029.models.User;
import TP4_no1_H071241029.utils.StringUtils;

public class MainLogin {
    private static ArrayList<User> listUser = new ArrayList<>();
    private static ArrayList<Profile> listUserProfile = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Memanggil method runApp();
        runApp();
    }

    private static void runApp() {
        // Menu Utama Aplikasi
        while (true) {
            System.out.println("-------------------------");
            System.out.println("Aplikasi Login Sederhana");
            System.out.println("-------------------------");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("0. Keluar");
            System.out.print("> ");

        // Menginput pilihan menu
            int selectMenu = sc.nextInt();
            sc.nextLine(); // buang newline

            switch (selectMenu) {
                case 1:
                    showLoginMenu();
                    break;
                case 2:
                    showRegisterMenu();
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan aplikasi :)");
                    System.exit(0);
                default:
                    System.out.println("Menu tidak tersedia. Silakan pilih ulang.");
            }
        }
    }

    private static void showLoginMenu() {
        // Halaman Login
        System.out.println("-------------------------");
        System.out.println("Login");
        // Menginput Username dan Menyimpannya di attribute username;
        System.out.println("Masukkan Username (atau ketik 'exit' untuk kembali)");
        System.out.print("> ");

        String username = sc.next();
        if (username.isEmpty() || username.equalsIgnoreCase("exit")) {
            runApp();
            return;
        }
        // Membuat variabel userIndex yang mana nanti akan menampung index dari user
        int userIndex = -1;
        for (int i = 0; i < listUser.size(); i++) {
            /*
             * TODO
             * Buatlah sebuah perkondisian (IF) yang akan
             * Mengecek apakah user index ke i dari listUser memiliki username yang sama
             * dengan username yang
             * diinput.
             * Jika ada ganti userIndex dengan Index dari User Tersebut, kemudian hentikan
             * perulangan
             */
            if (listUser.get(i).getUsername().equals(username)) {
                userIndex = i;
                break;
            }
        }
        // Saat userIndex tidak sama dengan -1 atau userIndexnya ditemukan
        if (userIndex != -1) {
            // Menginput Password
            System.out.println("Password");
            System.out.print("> ");
            String password = sc.next();
            /*
             * TODO
             * Mengecek apakah password dari User yang login berdasarkan username
             * sama dengan password yang diinput sebelumnya, kemudian simpan
             * hasilnya di variabel isPasswordMatch
             */
            boolean isPasswordMatch = listUser.get(userIndex).getPassword().equals(password);
            // Jika passwordnya sama maka berhasil login
            if (isPasswordMatch) {
                System.out.println("Berhasil Login");
                /*
                 * TODO
                 * panggil method showDetailUser dan kirimkan data Profile User yang login
                 */
                showDetailUser(listUserProfile.get(userIndex));
                System.exit(0);
            } else {
                // saat password salah akan menampikan password salah
                System.out.println("Password Salah");
            }
        }
        else {
            System.out.println("Username tidak ditemukan!");
        }
    }

    private static void showRegisterMenu() {
        System.out.println("-------------------------");
        System.out.println("REGISTER");

        // Menginput username dan password
        String username;
        while (true) {
            System.out.println("Username (atau ketik 'exit' untuk batal)");
            System.out.print("> ");
            username = sc.nextLine();
            if (username.equalsIgnoreCase("exit")) {
                runApp();
                return;
            } else if (!username.isEmpty()) {
                break;
            } else {
                System.out.println("Username tidak boleh kosong!");
            }
        }
        String password;
        while (true) {
            System.out.println("Password");
            System.out.print("> ");
            password = sc.nextLine();
            if (!password.isEmpty()) {
                break;
            } else {
                System.out.println("Password tidak boleh kosong!");
            }
        }
        /*
         * TODO
         * Buatlah atau Instance objek User baru, dan tambahkan
         * username dan password yang diinput sebelumnya secara langsung
         * saat instance User
         */
        User user = new User(username, password);
        /*
         * TODO
         * Buatlah atau Instance objek Profile baru
         */
        Profile profile = new Profile();

        // Menginput Data Profile
        String fullName;
        while (true) {
            System.out.println("Nama Lengkap");
            System.out.print("> ");
            fullName = sc.nextLine();
            if (!fullName.isEmpty()) break;
            System.out.println("Nama lengkap tidak boleh kosong!");
        }
        int age = -1;
        while (true) {
            System.out.println("Umur");
            System.out.print("> ");
            if (sc.hasNextInt()) {
                age = sc.nextInt();
                sc.nextLine();
                if (age > 0) break;
            } else {
                sc.nextLine(); // clear invalid input
            }
            System.out.println("Mohon mengisi dengan benar.");
        }
        String hobby;
        while (true) {
            System.out.println("Hobby");
            System.out.print("> ");
            hobby = sc.nextLine();
            if (!hobby.isEmpty()) break;
            System.out.println("Hobby tidak boleh kosong!");
        }

        /*
         * TODO
         * Berikan nilai fullName, age, dan hobby ke objek profile yang telah
         * di Instance sebelumnya. Nilai ini diperoleh dari data profile yang
         * diinput sebelumnya
         */
        profile.setFullName(fullName);
        profile.setAge(age);
        profile.setHobby(hobby);
        /*
         * TODO
         * Berikan nilai nickName ke objek profile,
         * Nilai ini diperoleh menggunakan static method yang dibuat di class
         * StringUtils, dengan mengirimkan fullName yang diinput sebelumnya
         */
        profile.setNickName(StringUtils.getNickName(fullName));
        // Menambahkan user yang dibuat ke list user
        listUser.add(user);
        // Menambahkan profile user yang dibuat ke list profile
        listUserProfile.add(profile);
        System.out.println("-------------------------");
        System.out.println("Berhasil Membuat User Baru!!");
        runApp();
    }

    private static void showDetailUser(Profile profile) {
        /*
         * TODO *
         * Tampilkan semua data profile user yang login
         */
        System.out.println("=========================");
        System.out.println("SELAMAT DATANG !!");
        System.out.println("=========================");
        System.out.println("Nama Lengkap : " + profile.getFullName());
        System.out.println("Nama Panggilan : " + profile.getNickName());
        System.out.println("Umur : " + profile.getAge());
        System.out.println("Hobby : " + profile.getHobby());
    }
}