/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:
    Input: [0,1,0,3,12]
    Output: [1,3,12,0,0]

Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.


[0,1,0,3,12]

*/

import java.util.Arrays;

public class MoveZeros {


    /**
     * same idea as bubble sort
     * time: O(n)
     * space: O(1)
     */
    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }

        int start = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[start] = nums[i];
                start++;
            }
        }

        for(int i = start; i < nums.length; i++){
            nums[i] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }


    public static void main(String[] args) {
        int[] input = new int[]{0,1,0,3,12};
        moveZeroes(input);

    }
}
