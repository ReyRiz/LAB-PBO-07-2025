package login_app.utils;

public class StringUtils {
    public static String generateNickName(String fullName) {

        fullName = fullName.trim();

        String[] parts = fullName.split("\\s+");

        if (parts.length == 1) {

            return parts[0];
        } else {

            return parts[parts.length - 1]; 
        }
    }
}
