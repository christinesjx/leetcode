import java.util.*;

/*
Given two arrays, write a function to compute their intersection.

Example 1:
    Input: nums1 = [1,2,2,1], nums2 = [2,2]
    Output: [2]

Example 2:
    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    Output: [9,4]

Note:
    Each element in the result must be unique.
    The result can be in any order.
 */
public class IntersectionOfTwoArrays {

    /**
     * Binary Search
     * time: O(nlgn)
     * space: O(n)
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection1(int[] nums1, int[] nums2) {

        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums1.length; i++){

            System.out.println(nums1[i]);
            int target = nums1[i];
            int low = 0;
            int high = nums2.length - 1;

            while(low <= high){

                int mid = (high - low) / 2 + low;

                System.out.println(" "+nums2[mid]);
                if(nums2[mid] == target){
                    set.add(target);
                    break;
                }else if(nums2[mid] > target){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
        }

        int i = 0;
        int[] res = new int[set.size()];
        for(Integer num: set){
            res[i] = num;
            i++;
        }
        return res;


    }

    /**
     * HashSet retainAll
     * time: O(n)
     * space: O(n)
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection2(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for(int num: nums1){
            set1.add(num);
        }
        for(int num: nums2){
            set2.add(num);
        }

        set1.retainAll(set2);

        int i = 0;
        int[] res = new int[set1.size()];
        for(int num: set1){
            res[i++] = num;
        }

        return res;
    }



    public static void main(String[] args) {

        int[] input1 = new int[]{1,2,2,1};
        int[] input2 = new int[]{2,2};

        int[] res = intersection1(input1, input2);

        System.out.println(Arrays.toString(res));

    }
}
