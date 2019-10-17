/*


Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:
    Input: 16
    Output: true

Example 2:
    Input: 14
    Output: false

*/

public class ValidPerfectSquare {

    //Binary Search
    public static boolean isPerfectSquare(int num) {

        long low = 0;
        long high = num;

        while(low <= high){

            long mid = (low + high) / 2;


            if(mid * mid == num){
                return true;
            }

            if(mid * mid < num){

                mid++;
                low = mid;
            }

            if(mid * mid > num){
                mid--;
                high = mid;

            }
        }

        return false;
    }
}
