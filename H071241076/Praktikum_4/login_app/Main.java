package login_app;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import login_app.models.Profile;
import login_app.models.User;
import login_app.utils.StringUtils;

public class Main {
    private static ArrayList<User> listUser = new ArrayList<>();
    private static ArrayList<Profile> listUserProfile = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        runApp();
    }

    private static void runApp() {
        System.out.println("-------------------------");
        System.out.println("Aplikasi Login Sederhana");
        System.out.println("-------------------------");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.print("> ");

        int selectMenu = getInputInteger();
        switch (selectMenu) {
            case 1:
                showLoginMenu();
                break;
            case 2:
                showRegisterMenu();
                break;
            default:
                System.out.println("Pilihan tidak valid, coba lagi!");
                runApp();
        }
    }

    private static void showLoginMenu() {
        System.out.println("-------------------------");
        System.out.println("Login");
        System.out.println("Masukkan Username");
        System.out.print("> ");
        String username = sc.nextLine();

        int userIndex = -1;
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getUsername().equals(username)) {
                userIndex = i;
                break;
            }
        }

        if (userIndex != -1) {
            System.out.println("Password");
            System.out.print("> ");
            String password = sc.nextLine();

            boolean isPasswordMatch = listUser.get(userIndex).getPassword().equals(password);

            if (isPasswordMatch) {
                System.out.println("Berhasil Login");
                showDetailUser(listUserProfile.get(userIndex));
                showMenuAfterLogin();
            } else {
                System.out.println("Password Salah");
                runApp();
            }
        } else {
            System.out.println("Username tidak ditemukan");
            runApp();
        }
    }

    private static void showRegisterMenu() {
        System.out.println("-------------------------");
        System.out.println("REGISTER");

        String username;
        while (true) {
            System.out.println("Username");
            System.out.print("> ");
            username = sc.nextLine();
            if (username.isEmpty()) {
                System.out.println("Username tidak boleh kosong!");
            } else if (isUsernameExist(username)) {
                System.out.println("Username sudah digunakan! Silakan masukkan username lain.");
            } else {
                break;
            }
        }

        String password;
        while (true) {
            System.out.println("Password (minimal 8 karakter)");
            System.out.print("> ");
            password = sc.nextLine();
            if (password.length() < 8) {
                System.out.println("Password harus minimal 8 karakter!");
            } else {
                break;
            }
        }

        User user = new User(username, password);
        Profile profile = new Profile();

        System.out.println("Nama Lengkap");
        System.out.print("> ");
        String fullName = sc.nextLine();
        while (fullName.isEmpty()) {
            System.out.println("Nama lengkap tidak boleh kosong!");
            System.out.print("> ");
            fullName = sc.nextLine();
        }

        System.out.println("Umur");
        System.out.print("> ");
        int age = getInputInteger();

        System.out.println("Hobby");
        System.out.print("> ");
        String hobby = sc.nextLine();
        while (hobby.isEmpty()) {
            System.out.println("Hobby tidak boleh kosong!");
            System.out.print("> ");
            hobby = sc.nextLine();
        }

        profile.setFullName(fullName);
        profile.setAge(age);
        profile.setHobby(hobby);
        profile.setNickName(StringUtils.generateNickName(fullName));

        listUser.add(user);
        listUserProfile.add(profile);

        System.out.println("-------------------------");
        System.out.println("Berhasil Membuat User Baru!!");
        runApp();
    }

    private static void showDetailUser(Profile profile) {
        System.out.println("-------------------------");
        System.out.println("Detail Profile");
        System.out.println("Nama Lengkap: " + profile.getFullName());
        System.out.println("Nickname    : " + profile.getNickName());
        System.out.println("Umur        : " + profile.getAge());
        System.out.println("Hobby       : " + profile.getHobby());
        System.out.println("-------------------------");
    }

    private static void showMenuAfterLogin() {
        while (true) {
            System.out.println("Menu Setelah Login:");
            System.out.println("1. Logout");
            System.out.print("> ");

            int menu = getInputInteger();
            if (menu == 1) {
                System.out.println("Logout berhasil!");
                runApp(); 
                break;
            } else {
                System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }
    }

    private static boolean isUsernameExist(String username) {
        for (User user : listUser) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    private static int getInputInteger() {
        while (true) {
            try {
                int input = sc.nextInt();
                sc.nextLine(); 
                return input;
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                sc.nextLine(); 
                System.out.print("> ");
            }
        }
    }
}
