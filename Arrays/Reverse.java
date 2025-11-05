import java.util.*;

public class Array_Reverse {
    // reverse array in place
    public static void reverse(int[] arr) {
        int left = 0, right = arr.length - 1;
        while(left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        System.out.println("Before reverse: " + Arrays.toString(nums));
        reverse(nums);
        System.out.println("After reverse: " + Arrays.toString(nums));
    }
}
