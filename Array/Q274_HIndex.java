package Array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

/**
 * 274. H-Index
 * https://leetcode.com/problems/h-index/description/
 */

/*
Given an array of citations (each citation is a non-negative integer) of a researcher,
write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia:
"A scientist has index h if h of his/her N papers have at least h citations each,
and the other N − h papers have no more than h citations each."

Example:
    Input: citations = [3,0,6,1,5]
    Output: 3
    Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
                 received 3, 0, 6, 1, 5 citations respectively.
                 Since the researcher has 3 papers with at least 3 citations each and the remaining
                 two with no more than 3 citations each, her h-index is 3.

Note: If there are several possible values for h, the maximum one is taken as the h-index.
 */

public class Q274_HIndex {

    /**
     * Time complexity : O(nlogn). Comparison sorting dominates the time complexity.
     * Space complexity : O(1).
     *
     * sort citations array
     * plot a histogram of the array and find the largest square
     */
    public static int hIndex(int[] citations) {

        Arrays.sort(citations);

        int squareLength = 0;

        //find the largest square
        for(int i = 0; i < citations.length; i++){
            int citation = citations[citations.length - i - 1];
            if(citation > i){
                squareLength++;
            }else{
                // it is not a square,break the loop
                break;
            }
        }

        return squareLength;
    }

    public static void main(String[] args) {

        int[] input = new int[]{3,0,6,1,5};
        System.out.println(hIndex(input));

    }
}
