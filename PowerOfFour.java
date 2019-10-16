/*
Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example 1:
    Input: 16
    Output: true


Example 2:
    Input: 5
    Output: false

Follow up: Could you solve it without loops/recursion?




*/

public class PowerOfFour {

/*

    64 = 01000000
    16 = 00010000
    4  = 00000100
    1  = 00000001

*/

    public boolean isPowerOfFour(int num) {

        if(num <= 0){
            return false;
        }

        int mask = 1;
        while(mask != 0){

            if((num ^ mask) == 0){
                return true;
            }
            mask <<= 2;
        }

        return false;


    }


}

