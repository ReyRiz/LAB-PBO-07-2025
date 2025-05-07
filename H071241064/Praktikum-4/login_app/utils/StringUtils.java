package login_app.utils;

public class StringUtils {
    
    public static String getNickname(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException("Full name tidak boleh kosong.");
        }

        String[] words = fullName.trim().split("\\s+");

        if (words.length == 1) {
            return words[0];
        } else {
            return words[1];
        }
    }
}
