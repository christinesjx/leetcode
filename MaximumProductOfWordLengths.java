/*

Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

Example 1:
    Input: ["abcw","baz","foo","bar","xtfn","abcdef"]
    Output: 16
    Explanation: The two words can be "abcw", "xtfn".

Example 2:
    Input: ["a","ab","abc","d","cd","bcd","abcd"]
    Output: 4
    Explanation: The two words can be "ab", "cd".

Example 3:
    Input: ["a","aa","aaa","aaaa"]
    Output: 0
    Explanation: No such pair of words.

*/

public class MaximumProductOfWordLengths {
/*

    Bit manipulation

    val |= 1 << (words[i].charAt(j) - 'a');

    "abc" = 0111 = 7

    'a':
        1 << ('a'- 'a')
        1 << 0
        1
        val = 0001

    'b':
        1 << ('b' - 'a')
        1 << 1
        10
        val = 0001 | 0010 = 0011

    'c':
        1 << ('c' - 'a')
        1 << 2
        100
        val = 0011 | 0100 = 0111

*/

    public int maxProduct(String[] words) {

        int max = 0;
        int[] bytes = new int[words.length];

        for(int i = 0; i < words.length; i++){
            int val = 0;

            for(int j = 0; j < words[i].length(); j++){
                val |= 1 << (words[i].charAt(j) - 'a');
            }

            bytes[i] = val;
        }


        for(int i = 0; i < bytes.length - 1; i++){
            for(int j = i + 1; j < bytes.length; j++){

                if((bytes[i] & bytes[j]) == 0){
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }


        return max;
    }
}
