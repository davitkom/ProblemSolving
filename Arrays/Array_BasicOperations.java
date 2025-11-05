import java.util.*;

public class Array_BasicOperations {
    // find max and min in array
    public static void main(String[] args) {
        int[] nums = {5, 3, 9, 1, 6, 8};
        int max = nums[0];
        int min = nums[0];
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > max) max = nums[i];
            if(nums[i] < min) min = nums[i];
        }
        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Max value: " + max);
        System.out.println("Min value: " + min);
    }
}
