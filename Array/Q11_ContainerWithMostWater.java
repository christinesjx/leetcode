package Array;

/**
 * 11. Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/description/
 */
/*
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49
 */
public class Q11_ContainerWithMostWater {

    /**
     * two pointers
     *
     * Time complexity : O(n)O(n). Single pass.
     * Space complexity : O(1)O(1). Constant space is used.
     */
    public static int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right){

            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(area, maxArea);

            if (height[left] < height[right]){
                left++;
            }else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(input));
    }
}
