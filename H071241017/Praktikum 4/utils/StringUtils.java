package utils;

public class StringUtils {
    public static String getNickName(String fullName) {
        String[] parts = fullName.split(" ");
        return parts[parts.length - 1];
    }
}


