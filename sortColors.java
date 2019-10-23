
/*

Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:
    Input: [2,0,2,1,1,0]
    Output: [0,0,1,1,2,2]


Follow up:

A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space?

*/

import java.util.Arrays;

public class sortColors {

    /**
     * Counting sort
     * two pass
     * @param nums
     */
    public static void sortColors(int[] nums) {

        int[] counts = new int[3];
        for(int num: nums){

            counts[num]++;
        }

        System.out.println(Arrays.toString(counts));

        int j = 0;
        for(int i = 0; i < counts.length; i++){
            while (counts[i] != 0){
                nums[j] = i;
                j++;
                counts[i]--;
            }
        }

        System.out.println(Arrays.toString(nums));

    }

    /**
     * One pass
     * @param nums
     */
    public static void sortColors1(int[] nums){

        int i = 0;
        int left = 0;
        int right = nums.length - 1;
        while(i <= right){

            if(nums[i] == 1){
                i++;
            }else if(nums[i] == 0){
                swap(nums, i, left);
                i++;
                left++;
            }else if(nums[i] == 2){
                swap(nums, i, right);
                right--;
            }

        }

        System.out.println(Arrays.toString(nums));

    }

    public static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }




    public static void main(String[] args) {
        int[] input = new int[]{2,0,2,1,1,0};
        System.out.println(Arrays.toString(input));
        sortColors1(input);
    }

}
