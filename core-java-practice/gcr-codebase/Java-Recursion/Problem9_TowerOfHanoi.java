public class Problem9_TowerOfHanoi {
    static void solve(int n,char src,char aux,char dest){
        if(n==1){
            System.out.println("Move disk 1 from "+src+" to "+dest);
            return;
        }
        solve(n-1,src,dest,aux);
        System.out.println("Move disk "+n+" from "+src+" to "+dest);
        solve(n-1,aux,src,dest);
    }
}