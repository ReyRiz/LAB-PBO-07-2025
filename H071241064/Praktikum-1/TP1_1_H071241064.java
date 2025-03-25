import java.util.Scanner;

public class TP1_1_H071241064 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan Judul Film: ");
        String judul = input.nextLine();
       
        String hasil = Title(judul); 
        System.out.println(hasil);

        input.close();
    }

    public static String Title(String str) {
        char[] lower = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        
        str = str.toLowerCase();
        
        char[] chars = str.toCharArray();
        
        boolean capitalizeNext = true;
        
        for (int i = 0; i < chars.length; i++) {
            if (capitalizeNext && chars[i] >= 'a' && chars[i] <= 'z') {
                for (int j = 0; j < lower.length; j++) {
                    if (chars[i] == lower[j]) {
                        chars[i] = upper[j]; 
                        break;
                    }
                }
            }
            
            capitalizeNext = (chars[i] == ' ');
        }
        
        return new String(chars);
    }
} 
