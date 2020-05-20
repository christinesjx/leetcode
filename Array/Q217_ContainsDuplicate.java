package Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 217. Contains Duplicate
 * https://leetcode.com/problems/contains-duplicate/description/
 */

/*
Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array,
and it should return false if every element is distinct.

Example 1:
    Input: [1,2,3,1]
    Output: true

Example 2:
    Input: [1,2,3,4]
    Output: false

Example 3:
    Input: [1,1,1,3,3,4,3,2,4,2]
    Output: true
 */
public class Q217_ContainsDuplicate {

    /**
     * Time complexity : O(n). We do search() and insert() for n times and each operation takes constant time.
     * Space complexity : O(n). The space used by a hash table is linear with the number of elements in it.
     */
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums){
            if (set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }

    /**
     * Time complexity : O(nlogn). Sorting is O(nlogn) and the sweeping is O(n).
     *                   The entire algorithm is dominated by the sorting step, which is O(nlogn).
     * Space complexity : O(1).
     */
    public static boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++){
            if (nums[i] == nums[i + 1]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[] input = new int[]{1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate(input));
    }
}
