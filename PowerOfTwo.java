/*


Given an integer, write a function to determine if it is a power of two.

        Example 1:
            Input: 1
            Output: true
            Explanation: 2^0 = 1

        Example 2:
            Input: 16
            Output: true
            Explanation: 2^4 = 16

        Example 3:
            Input: 218
            Output: false
*/

public class PowerOfTwo {
/*

    2^0 = 1 = 0b1
    2^1 = 2 = 0b10
    2^2 = 4 = 0b100
    2^3 = 8 = 0b1000

*/

    public boolean isPowerOfTwo(int n) {
        if(n <= 0){
            return false;
        }

        int one = 0;
        while(n != 0){

            if((n&1) == 1){
                one++;
            }
            n = n >> 1;

        }

        return one == 1;


    }


    //better
/*

      4 = 0b100
    4-1 = 0b011
      & = 0b000   = 0

      6 = 0b110
    6-1 = 0b101
      & = 0b100  != 0


*/
    public boolean isPowerOfTwo2(int n) {
        if (n == 0) return false;
        long x = (long) n;
        return (x & (x - 1)) == 0;
    }

}
