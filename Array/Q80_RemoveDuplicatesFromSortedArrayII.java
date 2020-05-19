package Array;

/**
 * 80. Remove Duplicates from Sorted Array II
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 */

/*
Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:
    Given nums = [1,1,1,2,2,3],
    Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
    It doesn't matter what you leave beyond the returned length.

Example 2:
    Given nums = [0,0,1,1,1,1,2,3,3],
    Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.
    It doesn't matter what values are set beyond the returned length.

Clarification:
    Confused why the returned value is an integer but your answer is an array?
    Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.

    Internally you can think of this:
        // nums is passed in by reference. (i.e., without making a copy)
        int len = removeDuplicates(nums);

        // any modification to nums in your function would be known by the caller.
        // using the length returned by your function, it prints the first len elements.
        for (int i = 0; i < len; i++) {
            print(nums[i]);
        }
 */
public class Q80_RemoveDuplicatesFromSortedArrayII {

    /*
    two pointers with a count variable
    same logic as Q26

    if count less than 2, record the num and i++.
    otherwise, do nothing
     */
    public static int removeDuplicates(int[] nums) {

        if (nums.length <= 1) {
            return 1;
        }

        int i = 0;
        int count = 1;

        for (int j = 1; j < nums.length; j++) {

            if (nums[i] != nums[j]) {
                i++;
                count = 1;
                nums[i] = nums[j];

            } else if (nums[i] == nums[j] && count < 2) {
                i++;
                count++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }



    public static void main(String[] args) {
        int[] input = new int[]{1,1,1,2,2,3};
        System.out.println(removeDuplicates(input));
    }
}
