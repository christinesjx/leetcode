
/*
Given a collection of intervals, merge all overlapping intervals.

        Example 1:
            Input: [[1,3],[2,6],[8,10],[15,18]]
            Output: [[1,6],[8,10],[15,18]]
            Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

        Example 2:
            Input: [[1,4],[4,5]]
            Output: [[1,5]]
            Explanation: Intervals [1,4] and [4,5] are considered overlapping.


        NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.



    1. [1,3][2,6]  --> [1,6]
    2. [1,3][3,6]  --> [1,6]
    3. [1,4][2,3]  --> [1,4]
    4. [2,4][2,5]  --> [2,5]



*/

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {


    public int[][] merge(int[][] intervals) {




        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] i1, int[] i2) {
                return i1[0] - i2[0];
            }
        });


        int count = intervals.length;

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] <= intervals[i - 1][1] && intervals[i][0] >= intervals[i-1][0]) {

                if(intervals[i][1] < intervals[i-1][1]){
                    intervals[i][1] = intervals[i-1][1];
                }

                if(intervals[i][0] > intervals[i-1][0]){
                    intervals[i][0] = intervals[i-1][0];
                }

                intervals[i-1][0] = -1;
                intervals[i-1][1] = -1;


                count--;

            }
        }








        int[][] res = new int[count][2];
        int j = 0;

        System.out.println(Arrays.toString(res));

        for(int i = 0; i < intervals.length; i++){
            if(intervals[i][0] != -1 && intervals[i][1] != -1){
                res[j][0] = intervals[i][0];
                res[j][1] = intervals[i][1];

                j++;
            }

            System.out.println(intervals[i][0] + " " + intervals[i][1]);
        }

        return res;

    }


}
