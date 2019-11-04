/*
A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Example 1:
    Input: nums = [1,2,3,1]
    Output: 2
    Explanation: 3 is a peak element and your function should return the index number 2.

Example 2:
    Input: nums = [1,2,1,3,5,6,4]
    Output: 1 or 5
    Explanation: Your function can return either index number 1 where the peak element is 2,
                 or index number 5 where the peak element is 6.

Note:
Your solution should be in logarithmic complexity.
 */

import java.util.ArrayList;
import java.util.Arrays;

public class FindPeakElement {
    /**
     * Linear Search
     * time: O(n)
     * space: O(1)
     */
    public static int findPeakElement(int[] nums) {

        if(nums == null || nums.length == 0){
            return -1;
        }

        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] > nums[i+1]){
                return i;
            }
        }

        return nums.length - 1;
    }

    /**
     * Binary Search
     * time: O(lgn)
     * space: O(1)
     * @param nums
     * @return
     */
    public static int findPeakElement1(int[] nums) {

        /*
        [1, 2, 1, 3, 5, 6, 4]
        Before: low = 0; high = 6; mid = 3
        After:  low = 4; high = 6; mid = 3
        Before: low = 4; high = 6; mid = 5
        After:  low = 4; high = 5; mid = 5
         */

        System.out.println(Arrays.toString(nums));
        int low = 0;
        int high = nums.length - 1;

        while(low + 1 < high){

            int mid = (high - low) / 2 + low;
            System.out.println("Before: low = " + low + "; high = "+ high + "; mid = " + mid);

            if(nums[mid] > nums[mid + 1]){
                high = mid;
            }else{
                low = mid + 1;
            }
            System.out.println("After:  low = " + low + "; high = "+ high + "; mid = " + mid);

        }

        if(nums[low] > nums[high]){
            return low;
        }
        return high;
    }


    public static void main(String[] args) {

        int[] input = new int[]{1,2,1,3,5,6,4};
        System.out.println(findPeakElement1(input));

    }

    }
