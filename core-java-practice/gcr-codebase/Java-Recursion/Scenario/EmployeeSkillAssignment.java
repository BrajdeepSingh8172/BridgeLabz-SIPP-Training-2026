import java.util.*;
public class EmployeeSkillAssignment {
    static void findTeams(int[] arr,int idx,int target,List<Integer> curr){
        if(target==0){
            System.out.println(curr);
            return;
        }
        if(idx==arr.length || target<0) return;

        curr.add(arr[idx]);
        findTeams(arr,idx+1,target-arr[idx],curr);

        curr.remove(curr.size()-1);
        findTeams(arr,idx+1,target,curr);
    }
}