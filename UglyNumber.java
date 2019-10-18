/*
Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

Example 1:
    Input: 6
    Output: true
    Explanation: 6 = 2 × 3

Example 2:
    Input: 8
    Output: true
    Explanation: 8 = 2 × 2 × 2

Example 3:
    Input: 14
    Output: false
    Explanation: 14 is not ugly since it includes another prime factor 7.

Note:

1 is typically treated as an ugly number.
Input is within the 32-bit signed integer range: [−231,  231 − 1].

*/

public class UglyNumber {

    public boolean isUgly(int num) {
        long numInput = num;

        if(numInput <= 0){
            return false;
        }

        while(numInput != 1){

            if(numInput % 2 == 0){
                numInput /= 2;
            } else if(numInput % 3 == 0){
                numInput /= 3;
            } else if(numInput % 5 == 0){
                numInput /= 5;
            }else{
                return false;
            }

        }

        return true;
    }
}
