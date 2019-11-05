/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:
    Input: [3,4,5,1,2]
    Output: 1

Example 2:
    Input: [4,5,6,7,0,1,2]
    Output: 0

 */
public class FindMinimumInRotatedSortedArray {

    /**
     * Binary Search
     * time: O(lgn)
     * space: O(1)
     * @param nums
     * @return
     */
    public static int findMin(int[] nums) {

        if(nums == null || nums.length == 0){
            return 0;
        }

        if(nums.length == 1){
            return nums[0];
        }

        int low = 0;
        int high = nums.length - 1;

        int min = Integer.MAX_VALUE;

        while(low <= high){
            int mid = (high - low) / 2 + low;

            min = Math.min(min, nums[mid]);

            if(nums[low] <= nums[mid] ){
                // left is sorted, right is unsorted
                min = Math.min(min, nums[low]);
                low = mid + 1;

            }else{
                // right is sorted, left is unsorted
                min = Math.min(min, nums[mid]);
                high = mid - 1;

            }
        }

        return min;
    }

    public static void main(String[] args) {

        int[] input = new int[]{2};
        System.out.println(findMin(input));
    }
}
