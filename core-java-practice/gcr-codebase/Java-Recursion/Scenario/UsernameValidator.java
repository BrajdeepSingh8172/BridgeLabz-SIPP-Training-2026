public class UsernameValidator {
    static boolean isValid(String s,int idx){
        if(idx==s.length()) return true;
        char ch=s.charAt(idx);
        if(ch<'a' || ch>'z') return false;
        return isValid(s,idx+1);
    }
}