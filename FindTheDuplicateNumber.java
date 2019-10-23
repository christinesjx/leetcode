/*

Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Example 1:
    Input: [1,3,4,2,2]
    Output: 2

Example 2:
    Input: [3,1,3,4,2]
    Output: 3

Note:
    You must not modify the array (assume the array is read only).
    You must use only constant, O(1) extra space.
    Your runtime complexity should be less than O(n2).
    There is only one duplicate number in the array, but it could be repeated more than once.


*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindTheDuplicateNumber {


    /**
     * set
     */
    public static int findDuplicate1(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        Set<Integer> set = new HashSet<>();

        for(int num: nums){
            if(set.contains(num)){
                return num;
            }
            set.add(num);

        }
        return 0;
    }

    /**
     * sort, check neighbor
     */
    public static int findDuplicate2(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == nums[i+1]){
                return nums[i];
            }
        }
        return 0;
    }

    /**
     * same idea as counting sort
     */
    public static int findDuplicate3(int[] nums) {

        if(nums == null || nums.length == 0){
            return 0;
        }

        int max = 0;
        for(int num: nums){
            if(num > max){
                max = num;
            }
        }

        int[] counts = new int[max + 1];
        for(int num: nums){
            counts[num]++;
        }
        System.out.println(Arrays.toString(counts));

        for(int i = 0; i < counts.length; i++){
            if(counts[i] > 1){
                return i;
            }
        }

        return 0;

    }

    public static void main(String[] args) {
        int[] input = new int[]{3,1,3,4,2};
        System.out.println(findDuplicate2(input));
    }
}
