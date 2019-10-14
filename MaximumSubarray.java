/*

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

        Example:

            Input: [-2,1,-3,4,-1,2,1,-5,4],
            Output: 6
            Explanation: [4,-1,2,1] has the largest sum = 6.


        Follow up:
        If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.


*/

public class MaximumSubarray {


/*

    currentSum = Math.max(nums[i], currentSum+nums[i]);
    maxSum = Math.max(maxSum, currentSum);

    [-2,1,-3,4,-1,2,1,-5,4]

    i=0:
        currentSum = -2
        maxSum = -2
    i=1:
        currentSum = max(1, -2+1) -> 1
        maxSum = max(-2, 1) -> 1
    i=2:
        currentSum = max(-3, 1+-3) -> -2
        maxSum = max(1, -2) -> 1
    i=3:
        currentSum = max(4, -2+4) -> 4
        maxSum = max(1, 4) -> 4
    i=4:
        currentSum = max(-1, 4+-1) -> 3
        maxSum = max(4, 3) -> 4
    i=5:
        currentSum = max(2, 3+2) -> 5
        maxSum = max(4, 5) ->5
    i=6:
        currentSum = max(1, 5+1) -> 6
        maxSum = max(5, 6) -> 6
    i=7:
        currentSum = max(-5, 6+-5) -> 1
        maxSum = max(6, 1) -> 6
    i=8:
        currentSum = max(4, 1+4) -> 5
        maxSum = max(6,5) -> 6

    return 6

*/


    // Greedy
    // Time complexity : O(N)
    // Space complexity : O(1), a constant space solution.
    public int maxSubArray(int[] nums) {


        int maxSum = Integer.MIN_VALUE;

        int currentSum = 0;

        for(int i = 0; i < nums.length; i++){

            currentSum = Math.max(nums[i], currentSum+nums[i]);
            maxSum = Math.max(maxSum, currentSum);

        }

        return maxSum;

    }




    //Divide and Conquer
    //Time complexity : O(NlogN)
    //Space complexity : O(logN) to keep the recursion stack.

    public int maxSubArray2(int[] nums) {

        int sum = maxSubArray2(nums, 0, nums.length-1)[2];

        return sum;
    }


    public int[] maxSubArray2(int[] nums, int low, int high){
        int[] left;
        int[] right;
        int[] cross;

        if(low == high){
            int[] rtn = {low, high, nums[low]};
            return rtn;

        }else{
            int mid = (int) Math.floor((low+high)/2);

            left = maxSubArray2(nums, low, mid);
            right = maxSubArray2(nums, mid +1, high);
            cross = maxCrossing2(nums, low, mid, high);
        }

        if((left[2] >= right[2]) && left[2] >= cross[2]){
            return left;
        }
        if((right[2] >= left[2]) && (right[2] >= cross[2])){

            return right;
        }

        return cross;


    }

    public int[] maxCrossing2(int[] nums, int low, int mid, int high){

        //left
        int maxSumLeft = Integer.MIN_VALUE;
        int sum = 0;
        int left = 0;
        for(int i = mid; i >= low; i--){
            sum += nums[i];

            if(sum >= maxSumLeft){
                maxSumLeft = sum;
                left = i;
            }
        }

        //right
        int maxSumRight = Integer.MIN_VALUE;
        sum = 0;
        int right = 0;
        for(int j = mid+1; j <= high; j++){
            sum += nums[j];

            if(sum >= maxSumRight){
                maxSumRight = sum;
                right = j;

            }
        }


        sum = maxSumLeft + maxSumRight;

        int[] rtn = {left, right, sum};

        return rtn;

    }



}
