/*

Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
The digits are stored such that the most significant digit is at the head of the list,
and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:
    Input: [1,2,3]
    Output: [1,2,4]
    Explanation: The array represents the integer 123.


Example 2:
    Input: [4,3,2,1]
    Output: [4,3,2,2]
    Explanation: The array represents the integer 4321.

*/

public class PlusOne {

    /*

       [8,9]
       [9,0]


      [1,9,9]
    [2,0,0,0]


    */

    public int[] plusOne(int[] digits) {

        int carry = 1;

        for(int i = digits.length - 1; i >= 0; i--){

            digits[i] += carry;
            carry = 0;

            if(digits[i] >= 10){
                digits[i] = 0;
                carry = 1;
            }
        }

        if(carry == 1){
            int[] res = new int[digits.length+1];
            res[0] = 1;

            for(int i = 1; i < res.length; i++){
                res[i] = digits[i-1];
            }
            return res;
        }

        return digits;
    }
}
