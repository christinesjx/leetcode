/*

Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Example 1:
    Input: num1 = "2", num2 = "3"
    Output: "6"

Example 2:
    Input: num1 = "123", num2 = "456"
    Output: "56088"

Note:
The length of both num1 and num2 is < 110.
Both num1 and num2 contain only digits 0-9.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
You must not use any built-in BigInteger library or convert the inputs to integer directly.



*/

import java.util.Arrays;

public class MultiplyStrings {
/*


            8 9  <- num2
            7 6  <- num1
        -------
            5 4
          4 8
          6 3
        5 6
        -------
        6 7 6 4


*/


    public static String multiply(String num1, String num2) {



        if(num1 == "0" || num2 == "0"){
            return "0";
        }

        char[] charNum1 = num1.toCharArray();
        char[] charNum2 = num2.toCharArray();
        int[] res = new int[num1.length() + num2.length()];


        for(int i = charNum1.length - 1; i >=0; i--){
            for(int j = charNum2.length - 1; j >= 0; j--){

                int m = (charNum1[i] - '0') * (charNum2[j] - '0');
                int sum = res[i+j+1] + m;

                res[i+j] += sum/10;
                res[i+j+1] = sum%10;

            }
        }


        StringBuilder sb = new StringBuilder();
        boolean leadingZeros = true;

        for(int i = 0; i < res.length; i++){

            if(res[i] != 0){
                leadingZeros = false;
            }

            if(!leadingZeros){
                sb.append(res[i]);
            }
        }


        return sb.toString();

    }




}
