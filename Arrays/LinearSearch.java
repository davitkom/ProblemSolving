import java.util.*;

public class Array_LinearSearch {
    // linear search example
    public static int linearSearch(int[] arr, int target) {
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == target) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {10, 25, 30, 45, 50};
        int target = 45;
        System.out.println("Array: " + Arrays.toString(nums));
        int pos = linearSearch(nums, target);
        if(pos != -1)
            System.out.println("Found " + target + " at index " + pos);
        else
            System.out.println(target + " not found in array");
    }
}
