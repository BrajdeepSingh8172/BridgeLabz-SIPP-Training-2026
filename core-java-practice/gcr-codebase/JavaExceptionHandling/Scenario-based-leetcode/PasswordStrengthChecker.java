public class PasswordStrengthChecker {

    public static void checkPassword(String password) {
        try {
            if (password == null) {
                throw new NullPointerException("Password evaluation failed: Object is uninitialized (null reference).");
            }
            if (password.isEmpty()) {
                throw new IllegalArgumentException("Password validation error: Entry cannot be entirely empty.");
            }
            if (password.length() < 8) {
                throw new IllegalArgumentException("Password validation error: Requirements demand at least 8 characters.");
            }
            if (!Character.isUpperCase(password.charAt(0))) {
                throw new IllegalArgumentException("Password validation error: The initial character must be an UPPERCASE letter.");
            }
            if (!Character.isDigit(password.charAt(password.length() - 1))) {
                throw new IllegalArgumentException("Password validation error: The terminal character must be a numeric digit.");
            }
            
            String specialChars = "@#$%&*";
            boolean hasSpecial = false;
            for (char ch : password.toCharArray()) {
                if (specialChars.contains(String.valueOf(ch))) {
                    hasSpecial = true;
                    break;
                }
            }
            if (!hasSpecial) {
                throw new IllegalArgumentException("Password validation error: Missing required special character component (@, #, $, %, &, *).");
            }

            System.out.println("Success: Strong, compliant security credentials verified.");

        } catch (NullPointerException | IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        checkPassword(null);
        checkPassword("");
        checkPassword("short1");
        checkPassword("lowercase1@");
        checkPassword("Nodigit@");
        checkPassword("NoSpecialChar1");
        checkPassword("ValidPass1#"); // Passes all validation steps
    }
}