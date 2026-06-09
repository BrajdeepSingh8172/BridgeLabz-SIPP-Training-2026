import.java.util.*;

class NumberOfStepsToReduceNumberToZero {

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		
		System.out.print(numberOfSteps(m));
		
	}
    public int numberOfSteps(int num) {
        int steps = 0;
        while(num>0){
            if(num % 2 == 0){
                num = num/2;
                steps++;
            }
            else{
                num--;
                steps++;
            }
        }
        return steps;
    }
}