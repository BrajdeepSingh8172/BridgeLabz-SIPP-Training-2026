public class Problem4_ReverseString {
    static String reverse(String s){
        if(s.isEmpty()) return s;
        return reverse(s.substring(1)) + s.charAt(0);
    }
}