public class Problem7_Power {
    static long power(long x,int n){
        if(n==0) return 1;
        return x * power(x,n-1);
    }
}