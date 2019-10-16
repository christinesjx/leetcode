/*

Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

Example 1:
    Input: [5,7]
    Output: 4

Example 2:
    Input: [0,1]
    Output: 0


*/

public class BitwiseANDofNumbersRange {

/*
    last bit of (odd number & even number) is 0.
    when m != n, There is at least an odd number and an even number, so the last bit position result is 0.


    0101
    0110
    0111
    ----
    0100



    010001
    010010
    010011
    010100
    ------
    010000   ==> (010) 000


    010001
    010010
    010011
    ------
    010000   ==> (0100) 00

*/

    public int rangeBitwiseAnd(int m, int n) {

        int offset = 0;

        //当m和n高位相等时，break
        while(m != n){
            m >>= 1;
            n >>= 1;
            offset++;
        }

        return m << offset;

    }
}
