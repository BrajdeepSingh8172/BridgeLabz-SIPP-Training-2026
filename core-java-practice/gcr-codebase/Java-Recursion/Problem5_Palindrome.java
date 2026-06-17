public class Problem5_Palindrome {
    static boolean isPalindrome(String s,int l,int r){
        if(l>=r) return true;
        if(s.charAt(l)!=s.charAt(r)) return false;
        return isPalindrome(s,l+1,r-1);
    }
}