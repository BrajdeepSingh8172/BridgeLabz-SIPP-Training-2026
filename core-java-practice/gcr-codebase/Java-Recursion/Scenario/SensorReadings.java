public class SensorReadings {
    static boolean isIncreasing(int[] arr,int idx){
        if(idx==arr.length-1) return true;
        return arr[idx] < arr[idx+1] && isIncreasing(arr,idx+1);
    }
}