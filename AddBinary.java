/*

Given two binary strings, return their sum (also a binary string).
The input strings are both non-empty and contains only characters 1 or 0.

Example 1:
    Input: a = "11", b = "1"
    Output: "100"

Example 2:
    Input: a = "1010", b = "1011"
    Output: "10101"

*/

public class AddBinary {


    /*

        a  b  cI   sum   cO
        1  1  1     1     1
        1  1  0     0     1
        1  0  1     0     1
        1  0  0     1     0
        0  1  1     0     1
        0  1  0     1     0
        0  0  1     1     0
        0  0  0     0     0

    */

    public static String addBinary(String a, String b) {

        int i = a.length()-1;
        int j = b.length()-1;

        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while(i >=0 || j >= 0){

            int sum = carry;

            if(i >= 0){
                sum += a.charAt(i) - '0';
                i--;
            }

            if(j >= 0){
                sum += b.charAt(j) - '0';
                j--;
            }

            if(sum == 2){
                carry = 1;
                sb.append(0);

            }else if(sum == 3){
                carry = 1;
                sb.append(1);

            }else{

                carry = 0;
                sb.append(sum);
            }

        }

        if(carry != 0){
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}
