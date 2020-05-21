package Array;

import java.util.Arrays;

/**
 * 42. Trapping Rain Water
 * https://leetcode.com/problems/trapping-rain-water/description/
 */

/*
Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it is able to trap after raining.

Example:
    Input: [0,1,0,2,1,0,1,3,2,1,2,1]
    Output: 6
 */
public class Q42_TrappingRainWater {

    /**
     * brute-force
     *
     * for each column, find the max height from the left and right.
     * then we can calculate the water at this column: water = min(maxLeft, maxRight) - height
     *
     * ex:
     * height: [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
     * left:   [0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3]
     * right:  [3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 1, 0]
     */
    public static int trap(int[] height) {
        if(height.length <=1){
            return 0;
        }

        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        for(int i = 0; i< height.length; i++){
            int max = 0;
            for(int j = i + 1; j< height.length; j++){
                if(height[j] > max){
                    max = height[j];
                }
            }
            maxRight[i] = max;
        }


        for(int i = height.length-1; i>=0; i--){
            int max = 0;
            for(int j = i-1; j>=0; j --){
                if(height[j] > max){
                    max = height[j];
                }
            }
            maxLeft[i] = max;
        }

        System.out.println("left:   "+Arrays.toString(maxLeft));
        System.out.println("right:  "+Arrays.toString(maxRight));

        int sum = 0;
        for(int i = 0; i< height.length; i++){
            int min = Math.min(maxLeft[i], maxRight[i]);
            if(height[i] < min){
                sum += (min - height[i]);
            }
        }

        return sum;
    }

    /**
     * two pointers
     */
    public static int trap1(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;

        int water = 0;
        while(left < right){

            if (maxLeft < maxRight){
                water += maxLeft - height[left];
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
            }else{
                water += maxRight - height[right];
                right--;
                maxRight = Math.max(maxRight, height[right]);
            }
        }

        return water;
    }

    /**
     * dp
     */
    public static int trap2(int[] height) {

        //TODO
        return -1;
    }

    public static void main(String[] args) {
        int[] input = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap1(input));
    }
}
