/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:
    Input: nums = [5,7,7,8,8,10], target = 8
    Output: [3,4]

Example 2:
    Input: nums = [5,7,7,8,8,10], target = 6
    Output: [-1,-1]

 */


import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {

    /**
     * time: O(lgn)
     * space: O(1)
     * @param nums
     * @param target
     * @return
     */

    public static int[] searchRange(int[] nums, int target) {

        if(nums == null || nums.length == 0){
            return new int[] {-1,-1};
        }
        if(findFirst(nums, target) == -1){
            return new int[] {-1,-1};
        }

        return new int[]{findFirst(nums,target), findLast(nums,target)};
    }


    public static int findFirst(int[] nums, int target){

        int start = 0;
        int end = nums.length - 1;

        while(start + 1 < end){
            int mid = (end - start) / 2 + start;

            if(nums[mid] < target){
                start = mid;
            }else{
                end = mid;
            }

        }

        if(nums[start] == target){
            return start;
        }
        if(nums[end] == target){
            return end;
        }

        return -1;
    }



    public static int findLast(int[] nums, int target){

        int start = 0;
        int end = nums.length - 1;

        while(start + 1 < end){
            int mid = (end - start) / 2 + start;

            if(nums[mid] > target){
                end = mid;
            }else{
                start = mid;
            }
        }

        if(nums[end] == target){
            return end;
        }
        if(nums[start] == target){
            return start;
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] input = new int[]{5,7,7,8,8,10};
        int[] res = searchRange(input, 8);

        System.out.println(Arrays.toString(res));
    }
}
