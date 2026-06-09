import java.util.*;

class RomanToInteger{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		int[] arr = new int[128];
		arr['I'] = 1;
        arr['V'] = 5;
        arr['X'] = 10;
        arr['L'] = 50;
        arr['C'] = 100;
        arr['D'] = 500;
        arr['M'] = 1000;
		
		int ans = 0;
		
		for(int i=0;i<s.length()-1;i++){
			int curr = s.charAt(i);
			int next = s.charAt(i+1);
			
			if(arr[curr]<arr[next]){
				ans -= arr[curr];
			}
			else{
				ans += arr[curr];
			}
		}
		
		ans += arr[s.charAt(s.length()-1)];
		System.out.print(ans);
	}
}