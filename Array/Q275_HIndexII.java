package Array;

/**
 * 275. H-Index II
 * https://leetcode.com/problems/h-index-ii/description/
 */


/*
Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher,
write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia:
"A scientist has index h if h of his/her N papers have at least h citations each,
and the other N − h papers have no more than h citations each."

Example:
    Input: citations = [0,1,3,5,6]
    Output: 3
    Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had
                 received 0, 1, 3, 5, 6 citations respectively.
                 Since the researcher has 3 papers with at least 3 citations each and the remaining
                 two with no more than 3 citations each, her h-index is 3.

Note: If there are several possible values for h, the maximum one is taken as the h-index.

Follow up:
    This is a follow up problem to H-Index, where citations is now guaranteed to be sorted in ascending order.
    Could you solve it in logarithmic time complexity?

 */
public class Q275_HIndexII {

    /**
     * Time complexity : O(logN) binary search
     * Space complexity : O(1), it's a constant space solution.
     *
     * goal: find the largest square using binary search
     *  plot the ascending array as histogram
     *  imagine citations[mid] and citations.length - mid are the two sides of a square
     *  citations[mid] is the "height"
     *  citations.length - mid is the "length"
     *  use binary search to find the two equal sides.
     *
     */
    public static int hIndex(int[] citations) {

        int left = 0;
        int right = citations.length - 1;
        int mid = 0;

        while(left <= right){
            mid = left + (right - left) / 2;

            if (citations[mid] == citations.length - mid){
                return citations.length - mid;
            }else if (citations[mid] < citations.length - mid){
                left = mid + 1;
            }else{
                right = mid - 1;
            }

        }

        // the amounts of elements that are larger than the left index.
        return citations.length - left;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,1,2,3,7,7,7,8};
        System.out.println(hIndex(input));

    }
}
