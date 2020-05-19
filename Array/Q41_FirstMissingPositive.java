package Array;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 41. First Missing Positive
 * https://leetcode.com/problems/first-missing-positive/description/
 */

/*
Given an unsorted integer array, find the smallest missing positive integer.

Example 1:
    Input: [1,2,0]
    Output: 3

Example 2:
    Input: [3,4,-1,1]
    Output: 2

Example 3:
    Input: [7,8,9,11,12]
    Output: 1

Note: Your algorithm should run in O(n) time and uses constant extra space.
 */

public class Q41_FirstMissingPositive {

    /**
     * Time complexity : O(N)
     * Space complexity : O(1)
     */
    public static int firstMissingPositive(int[] nums) {

        if(nums.length < 1){
            return -1;
        }

        Arrays.sort(nums);

        int prev = 1;
        boolean start = false;
        for (int num : nums) {

            if (num > 0) {

                if (num == 1) {
                    start = true;
                }

                if (num - prev > 1) {

                    if (!start) {
                        return 1;
                    }
                    return prev + 1;
                }
                prev = num;
            }
        }

        if(nums[nums.length - 1] <= 0 || !start){
            return 1;
        }

        return nums[nums.length-1] + 1;
    }



    public static void main(String[] args) {
        int[] input = new int[]{3,4,-1,1};
        System.out.println(firstMissingPositive(input));
    }
}
