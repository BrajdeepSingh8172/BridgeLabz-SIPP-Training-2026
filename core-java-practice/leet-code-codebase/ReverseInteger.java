import java.util.*;

class ReverseInteger {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.print(reverse(n));
		
	}
    public static int reverse(int x) {
        int ans = 0;
        int n = Math.abs(x);

        while (n > 0) {
            ans = ans * 10 + n % 10;
            n = n / 10;
        }

        if (x < 0) return -ans;
        return ans;
    }
}