package Array;
import java.util.Arrays;

/**
 * 189. Rotate Array
 * https://leetcode.com/problems/rotate-array/description/
 */

/*
Given an array, rotate the array to the right by k steps, where k is non-negative.

Follow up:
    Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
    Could you do it in-place with O(1) extra space?

Example 1:
    Input: nums = [1,2,3,4,5,6,7], k = 3
    Output: [5,6,7,1,2,3,4]
    Explanation:
    rotate 1 steps to the right: [7,1,2,3,4,5,6]
    rotate 2 steps to the right: [6,7,1,2,3,4,5]
    rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:
    Input: nums = [-1,-100,3,99], k = 2
    Output: [3,99,-1,-100]
    Explanation:
    rotate 1 steps to the right: [99,-1,-100,3]
    rotate 2 steps to the right: [3,99,-1,-100]

Constraints:
    1 <= nums.length <= 2 * 10^4
    It's guaranteed that nums[i] fits in a 32 bit-signed integer.
    k >= 0
 */
public class Q189_RotateArray {

    /**
     * Approach 1: in-place (brute-force)
     *
     * Time complexity: O(n×k). All the numbers are shifted by one step(O(n)) k times(O(n))
     * Space complexity: O(1). No extra space is used.
     */

    public static void rotate1(int[] nums, int k) {
        if(nums.length <= 1){
            return;
        }
        while (k != 0){
            rotate1Helper(nums);
            System.out.println(Arrays.toString(nums));
            k--;
        }
    }

    public static int[] rotate1Helper(int[] nums){
        int tmp = nums[nums.length - 1];
        for(int i = nums.length - 1; i > 0; i--){
            nums[i] = nums[i-1];
        }
        nums[0] = tmp;
        return nums;
    }

    /**
     * Approach 2: extra array
     * Time complexity: O(n). One pass is used to put the numbers in the new array.
     *                  And another pass to copy the new array to the original one.
     * Space complexity: O(n). Another array of the same size is used.
     */
    public static void rotate2(int[] nums, int k) {

        if(nums.length <= 1){
            return;
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            res[(i + k) % nums.length] = nums[i];
        }

        for(int i = 0; i < nums.length; i ++){
            nums[i] = res[i];
        }
        System.out.println(Arrays.toString(res));
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,4,5,6,7};
        rotate2(input, 3);
    }
}
