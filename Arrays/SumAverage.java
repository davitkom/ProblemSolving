import java.util.*;

public class Array_SumAverage {
    // calculate sum and average of array elements
    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 40, 50};
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
        }
        double avg = (double) sum / nums.length;
        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + avg);
    }
}
