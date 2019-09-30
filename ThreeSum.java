/*

Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

        Note:

        The solution set must not contain duplicate triplets.

        Example:

        Given array nums = [-1, 0, 1, 2, -1, -4],

        A solution set is:
        [
        [-1, 0, 1],
        [-1, -1, 2]
        ]


       nums    sort        target       low         high
        -1      -4                      -4
        0       -1
        1       -1            1                                 low+high < 1, low++
        2       0
        -1      1
        -4      2                                     2



*/


import java.util.*;

public class ThreeSum {


    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> soln = new ArrayList<>();

        if(nums == null || nums.length == 0){
            return soln;
        }

        Arrays.sort(nums);

        for(int i = 0; i<nums.length; i++){

            System.out.println(nums[i]);

            // we don't repeated list in our soln, if the next int is equal to current one, skip.
            if(i==0 || (i>0 && nums[i] != nums[i-1])){

                int low = i+1;
                int high = nums.length-1;
                int target = 0 - nums[i];

                while(low < high){

                    if(nums[low] + nums[high] == target){

                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[low]);
                        list.add(nums[high]);
                        soln.add(list);


                        while(low < high && nums[low] == nums[low+1]){
                            low++;
                        }
                        while(low < high && nums[high] == nums[high-1]){
                            high--;
                        }

                        low++;
                        high--;
                    }else if(nums[low] + nums[high] > target){
                        high --;

                    }else{
                        low ++;
                    }

                }


            }

        }

        return soln;

    }

}
