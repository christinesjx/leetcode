package Array;

/**
 * 243. Shortest Word Distance
 * https://leetcode.com/problems/shortest-word-distance/description/
 */

/*
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

Example:
    Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

    Input: word1 = “coding”, word2 = “practice”
    Output: 3

    Input: word1 = "makes", word2 = "coding"
    Output: 1

Note: You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
public class Q243_ShortestWordDistance {

    /**
     * brute-force
     */
    public static int shortestDistance(String[] words, String word1, String word2) {
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++){
            if (words[i].equals(word1)) {
                for (int j = 0; j < words.length; j++) {
                    if (words[j].equals(word2)){
                        distance = Math.min(Math.abs(i - j), distance);
                    }
                }
            }
        }
        return distance;
    }

    /**
     * one pass
     * record the most recent index of word1 and word2
     */
    public static int shortestDistance1(String[] words, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int distance = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++){
            if (words[i].equals(word1)){
                index1 = i;
            }else if (words[i].equals(word2)){
                index2 = i;
            }

            if (index1 != -1 && index2 != -1){
                distance = Math.min(distance, Math.abs(index1 - index2));
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"practice", "makes", "perfect", "coding", "makes"};
        System.out.println(shortestDistance1(strings, "coding", "practice"));
    }
}
