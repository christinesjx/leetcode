package Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 244. Shortest Word Distance II
 * https://leetcode.com/problems/shortest-word-distance-ii/description/
 */

/*
Design a class which receives a list of words in the constructor,
and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.
Your method will be called repeatedly many times with different parameters.

Example:
    Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
    Input: word1 = “coding”, word2 = “practice”
    Output: 3
    Input: word1 = "makes", word2 = "coding"
    Output: 1

Note: You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.


 */
public class Q244_ShortestWordDistanceII {

    public static void main(String[] args) {
        String[] input = new String[]{"practice", "makes", "perfect", "coding", "makes"};
        WordDistance wordDistance = new WordDistance(input);
        System.out.println(wordDistance.shortest("practice", "makes"));
    }

    static class WordDistance {

        private Map<String, List<Integer>> map = new HashMap<>();

        public WordDistance(String[] words) {

            for (int i = 0; i < words.length; i++) {
                if (!map.containsKey(words[i])) {
                    List<Integer> index = new ArrayList<>();
                    index.add(i);
                    map.put(words[i], index);
                } else {
                    List<Integer> index = map.get(words[i]);
                    index.add(i);
                    map.put(words[i], index);
                }
            }
        }

        public int shortest(String word1, String word2) {
            List<Integer> word1Index = map.get(word1);
            List<Integer> word2Index = map.get(word2);

            int distance = Integer.MAX_VALUE;
            for (int i = 0; i < word1Index.size(); i++) {
                for (int j = 0; j < word2Index.size(); j++) {
                    distance = Math.min(Math.abs(word1Index.get(i) - word2Index.get(j)), distance);
                }
            }
            return distance;
        }
    }
}
