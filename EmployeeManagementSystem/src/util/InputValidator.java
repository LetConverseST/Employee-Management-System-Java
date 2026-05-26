package util;

import java.util.regex.Pattern;

public class InputValidator {
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    private InputValidator() {
    }

    public static boolean isValidName(String name) {
        return !isNullOrEmpty(name);
    }

    public static boolean isValidSalary(double salary) {
        return salary > 0;
    }

    public static boolean isValidEmail(String email) {
        return !isNullOrEmpty(email) && EMAIL_PATTERN.matcher(email.trim()).matches();
    }

    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}
