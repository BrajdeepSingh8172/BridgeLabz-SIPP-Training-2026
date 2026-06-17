import java.util.*;
public class Problem8_Subsets {
    static void subsets(int[] arr,int idx,List<Integer> curr){
        if(idx==arr.length){
            System.out.println(curr);
            return;
        }
        subsets(arr,idx+1,curr);
        curr.add(arr[idx]);
        subsets(arr,idx+1,curr);
        curr.remove(curr.size()-1);
    }
}