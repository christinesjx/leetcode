package Array;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 299. Bulls and Cows
 * https://leetcode.com/problems/bulls-and-cows/
 */

/*
You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is.
Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit
and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows").
Your friend will use successive guesses and hints to eventually derive the secret number.

Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows.

Please note that both secret number and friend's guess may contain duplicate digits.

Example 1:
    Input: secret = "1807", guess = "7810"
    Output: "1A3B"
    Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.

Example 2:
    Input: secret = "1123", guess = "0111"
    Output: "1A1B"
    Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.

Note: You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
 */

public class Q299_BullsAndCows {


    /**
     * Time complexity : O(N^2)
     * Space complexity : O(1)
     */
    public static String getHint(String secret, String guess) {

        if(secret.length() < 1 || guess.length() < 1){
            return "0A0B";
        }

        char[] secretChars = secret.toCharArray();
        char[] guessChars = guess.toCharArray();

        int bull = 0;
        int cow = 0;

        // count bulls
        for (int i = 0; i < secretChars.length; i++) {
            if (secretChars[i] == guessChars[i]){
                bull++;
                secretChars[i] = 'x';
                guessChars[i] = 'x';
            }
        }


        // count cows
        for (char c : secretChars) {
            if (c != 'x') {
                for (int j = 0; j < guessChars.length; j++) {
                    if (c == guessChars[j]) {
                        cow++;
                        guessChars[j] = 'x';
                        break;
                    }
                }
            }
        }

        return bull + "A" + cow + "B";
    }

    public static void main(String[] args) {
        System.out.println(getHint("1807", "7810"));
    }

}
