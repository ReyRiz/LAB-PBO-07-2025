import java.util.Scanner;

public class No5 {
    public static void main(String[] args) {
        Scanner n = new Scanner(System.in);
        System.out.print("Masukkan password: ");
        String password = n.nextLine();

    
        if (isPasswordValid(password)) {
            System.out.println("Password valid");
        } else {
            System.out.println("Password tidak valid");
        }

        n.close();
    }

  
    public static boolean isPasswordValid(String password) {
        if (password.length() < 8) {
            return false;
        }

        boolean hasUpperCase = false; //untuk mengubah true
        boolean hasLowerCase = false;
        boolean hasDigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }

        return hasUpperCase && hasLowerCase && hasDigit;
    }
}
