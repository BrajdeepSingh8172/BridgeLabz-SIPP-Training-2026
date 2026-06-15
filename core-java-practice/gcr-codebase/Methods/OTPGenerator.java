import java.util.HashSet;

public class OTPGenerator {

    public static int generateOTP() {
        return 100000 + (int)(Math.random() * 900000);
    }

    public static boolean checkUnique(int[] otpArray) {

        HashSet<Integer> set = new HashSet<>();

        for (int otp : otpArray) {
            set.add(otp);
        }

        return set.size() == otpArray.length;
    }

    public static void main(String[] args) {

        int[] otpArray = new int[10];

        System.out.println("Generated OTPs:");

        for (int i = 0; i < 10; i++) {

            otpArray[i] = generateOTP();
            System.out.println(otpArray[i]);
        }

        System.out.println("All OTPs Unique = " + checkUnique(otpArray));
    }
}