/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

You are given a target value to search. If found in the array return true, otherwise return false.

Example 1:
    Input: nums = [2,5,6,0,0,1,2], target = 0
    Output: true

Example 2:
    Input: nums = [2,5,6,0,0,1,2], target = 3
    Output: false

Follow up:
    This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
    Would this affect the run-time complexity? How and why?
 */

public class SearchInRotatedSortedArrayII {

    /**
     * Binary Search
     * time: O(lgn) worst case: O(n)
     * space: O(1)
     * @param nums
     * @param target
     * @return
     */

    public static boolean search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = (high - low) / 2 + low;

            System.out.println("low " + low+ " hight " + high+ " mid " +mid);

            if(nums[mid] == target) return true;

            if(nums[low] < nums[mid] || nums[mid] > nums[high]){
                // left is sorted, ex: 1,2,2,2,2,0,0,
                // or right is unsorted, ex: 0,0,0,0,1
                if(nums[low] <= target && target < nums[mid]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else if(nums[mid] < nums[high] || nums[low] > nums[mid]){
                // right is sorted, ex: 4,5,0,0,0,0,1,2,3
                // or left is unsorted, ex: 3,0,0,0,0
                if(nums[mid] < target && target <= nums[high]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }else{
                // duplicates, ex: 1,1,3,1
                low++;
            }
        }

        return false;
    }


    public static void main(String[] args) {

        int[] input = new int[]{1,1,3,1};
        System.out.println(search(input, 3));
    }
}
