/*

Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example 1:
    Input: a = 1, b = 2
    Output: 3

Example 2:
    Input: a = -2, b = 3
    Output: 1


*/

public class SumOfTwoIntegers {

    /*

    1+2

    0001
    0010
    ----
    0011


    -2+3

    1111111111111110
    0000000000000011
    ----------------
    0000000000000001


    2+3

    0010
    0011
    ----
    0101


    0010
  & 0011
    ----
    0010

    */
    public int getSum(int a, int b) {
        int carry = 0;
        while(a != 0) {
            carry = (a & b);
            b = b ^ a;
            a = carry << 1;
        }
        return b;
    }

}
