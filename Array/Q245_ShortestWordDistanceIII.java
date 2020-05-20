package Array;

/**
 * 245. Shortest Word Distance III
 * https://leetcode.com/problems/shortest-word-distance-iii/description/
 */

/*
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

word1 and word2 may be the same and they represent two individual words in the list.

Example:
    Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

    Input: word1 = “makes”, word2 = “coding”
    Output: 1
    Input: word1 = "makes", word2 = "makes"
    Output: 3

Note: You may assume word1 and word2 are both in the list.
 */
public class Q245_ShortestWordDistanceIII {

    public static int shortestWordDistance(String[] words, String word1, String word2) {

        int index1 = -1;
        int index2 = -1;
        int distance = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++){
            if (word1.equals(word2) && words[i].equals(word1)){
                if(index1 >= index2){
                    index2 = i;
                }else{
                    index1 = i;
                }
            }else {
                if (words[i].equals(word1)) {
                    index1 = i;
                } else if (words[i].equals(word2)) {
                    index2 = i;
                }
            }

            if(index1 != -1 && index2 != -1){
                distance = Math.min(distance, Math.abs(index1 - index2));
            }
        }

        return distance;

    }

    public static void main(String[] args) {
        String[] strings = new String[]{"practice", "makes", "perfect", "coding", "makes"};
        System.out.println(shortestWordDistance(strings, "makes", "makes"));
    }
}
