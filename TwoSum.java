/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

        You may assume that each input would have exactly one solution, and you may not use the same element twice.

        Example:

        Given nums = [2, 7, 11, 15], target = 9,

        Because nums[0] + nums[1] = 2 + 7 = 9,
        return [0, 1].


*/


import java.util.HashMap;
import java.util.Map;

public class TwoSum {




    public int[] bruteForceTwoSum(int[] nums, int target) {

        int[] res = new int[2];

        for(int i = 0; i < nums.length-1; i++){

            res[0] = i;
            int num = target - nums[i];
            for(int j = 1; j < nums.length; j++){

                if(nums[j] == num){
                    res[1] = j;
                    return res;
                }

            }
        }

        return new int[]{};


    }


/*
                                            Map
            i   nums  target-nums[i]        key        value
            0     2     7                   7           0
            1     7     2                   2           1
            2     11    -2                  -2          2
            3     15    -6                  -6          3

*/


    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();


        for(int i = 0; i < nums.length; i++){
            map.put(target-nums[i], i);
        }

        for(int i = 0; i < nums.length; i++){

            if(map.containsKey(nums[i])){
                int index = map.get(nums[i]);
                if(i != index){
                    return new int[]{i, index};

                }
            }


        }
        return new int[]{};


    }


}


