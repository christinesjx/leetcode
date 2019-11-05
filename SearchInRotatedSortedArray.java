/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:
    Input: nums = [4,5,6,7,0,1,2], target = 0
    Output: 4

Example 2:
    Input: nums = [4,5,6,7,0,1,2], target = 3
    Output: -1
 */
public class SearchInRotatedSortedArray {
    /**
     * Binary Search
     * time: O(lgn)
     * space: O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = (high - low) / 2 + low;

            System.out.println("Before: low " + nums[low] + " high " + nums[high] + " mid " + nums[mid]);
            if(nums[mid] == target){
                return mid;
            }
            if(nums[low] <= nums[mid]){
                //left is sorted, ex: [3 4 5 6 7 8 0 1 2]
                if(target >= nums[low] && target < nums[mid]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else{
                //right is sorted, ex: [7 8 0 1 2 3 4 5 6]
                if(target > nums[mid] && target <= nums[high]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
            System.out.println("After:  low " + nums[low] + " high " + nums[high] + " mid " + nums[mid]);

        }
        return -1;
    }

    public static void main(String[] args) {

        int[] input = new int[]{4,5,6,7,0,1,2};
        System.out.println(search(input, 0));
    }
}