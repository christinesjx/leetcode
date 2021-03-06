/*
Given a sorted array and a target value, return the index if the target is found.
If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:
    Input: [1,3,5,6], 5
    Output: 2

Example 2:
    Input: [1,3,5,6], 2
    Output: 1

Example 3:
    Input: [1,3,5,6], 7
    Output: 4

Example 4:
    Input: [1,3,5,6], 0
    Output: 0

 */

public class SearchInsertPosition {

    /**
     * Binary Search
     * O(lgn)
     */

    public static int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while(left <= right){

            mid = (right - left) / 2 + left;

            if(nums[mid] == target){
                return mid;


            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        // find the index where the target should be inserted
        if(nums[mid] > target){
            return mid;
        }else{
            return mid + 1;
        }

    }

    public static void main(String[] args) {
        int[] input = new int[]{1,3,5,6};
        int target = 2;
        System.out.println(searchInsert(input, target));
    }
}
