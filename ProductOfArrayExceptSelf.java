/*


Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

        Example:
            Input:  [1,2,3,4]
            Output: [24,12,8,6]

        Note: Please solve it without division and in O(n).

        Follow up:
        Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)

*/


import java.util.Arrays;

public class ProductOfArrayExceptSelf {


/*                          product = left * right
   nums     product         left    right
    1          24           1       24
    2          12           1       12
    3          8            2       4
    4          6            6       1


*/


    public int[] productExceptSelf(int[] nums) {

        int[] res = new int[nums.length];
        int[] right = new int[nums.length];
        int[] left = new int[nums.length];

        int rightProduct = 1;
        int leftProduct = 1;

        left[0] = leftProduct;
        right[nums.length-1] = rightProduct;



        for(int i = 1; i < nums.length; i++){
            leftProduct *= nums[i-1];
            left[i] = leftProduct;

        }

        for(int i = nums.length-2; i >= 0; i--){
            rightProduct *= nums[i+1];
            right[i] = rightProduct;
        }

        for(int i = 0; i<nums.length;i++){
            res[i] = left[i] * right[i];
        }


        return res;




    }


}
