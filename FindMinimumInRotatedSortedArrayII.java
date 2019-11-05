/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

The array may contain duplicates.

Example 1:
    Input: [1,3,5]
    Output: 1

Example 2:
    Input: [2,2,2,0,1]
    Output: 0

Note:
    This is a follow up problem to Find Minimum in Rotated Sorted Array.
    Would allow duplicates affect the run-time complexity? How and why?
 */
public class FindMinimumInRotatedSortedArrayII {

    /**
     *
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

            if(nums[low] < nums[mid] || nums[mid] > nums[high]){
                //left is sorted, right is unsorted
                min = Math.min(nums[low], min);
                low = mid + 1;

            }else if(nums[mid] < nums[high] || nums[low] > nums[mid]){
                //right is sorted, left is unsorted
                min = Math.min(nums[mid], min);
                high = mid - 1;

            }else{
                min = Math.min(nums[mid], min);
                low++;
            }
        }

        return min;

    }

    public static void main(String[] args) {

        int[] input = new int[]{1,1};
        System.out.println(findMin(input));
    }
}
