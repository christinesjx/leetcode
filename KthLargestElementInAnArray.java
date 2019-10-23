/*

Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:
    Input: [3,2,1,5,6,4] and k = 2
    Output: 5


Example 2:
    Input: [3,2,3,1,2,4,5,5,6] and k = 4
    Output: 4
Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.
 */


import java.util.*;

public class KthLargestElementInAnArray {

    public static int findKthLargest(int[] nums, int k) {

        if(nums == null || nums.length == 0){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for(int num: nums){
            set.add(num);
            res.add(num);
        }

        Collections.sort(res);
        return res.get(res.size() - k);
    }

    public static void main(String[] args) {
        int[] input = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(input,4));


    }
}
