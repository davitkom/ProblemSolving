import java.util.*;

public class Array_BinarySearch {
    // binary search in sorted array
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            System.out.println("Checking index " + mid + " value " + arr[mid]);
            if(arr[mid] == target) return mid;
            if(arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 8, 10, 12};
        int target = 10;
        System.out.println("Array: " + Arrays.toString(nums));
        int result = binarySearch(nums, target);
        if(result != -1)
            System.out.println("Found " + target + " at index " + result);
        else
            System.out.println(target + " not found");
    }
}
