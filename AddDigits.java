/*

Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

Example:
    Input: 38
    Output: 2
    Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
                 Since 2 has only one digit, return it.

Follow up:
    Could you do it without any loop/recursion in O(1) runtime?




*/

public class AddDigits {




    /*
    38         ->     11        ->      2
    100110            1011              10


    67          ->      13          ->      4
    1000011             1101                0100


    */
    public int addDigits(int num) {


        if(num < 10){
            return num;
        }

        int sum = 0;
        while(true){

            if(sum < 10 && num == 0){
                return sum;
            }

            if(num == 0){
                num = sum;
                sum = 0;
            }

            sum += num % 10;
            num /= 10;
        }


    }

}
