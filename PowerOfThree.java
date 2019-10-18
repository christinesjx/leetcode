/*

Given an integer, write a function to determine if it is a power of three.

Example 1:
    Input: 27
    Output: true

Example 2:
    Input: 0
    Output: false

Example 3:
    Input: 9
    Output: true

Example 4:
    Input: 45
    Output: false

Follow up:
Could you do it without using any loop / recursion?



*/

public class PowerOfThree {

    /*

    1,3,9,27

    */
    public boolean isPowerOfThree(int n) {

        return (((Math.log(n)/Math.log(3)) % 1) == 0);

    }

}
