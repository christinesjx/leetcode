/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:
    s = "leetcode"
    return 0.

    s = "loveleetcode",
    return 2.

Note: You may assume the string contain only lowercase letters.
 */

public class FirstUniqueCharacterInAString {

    /**
     * bitmap
     * time: O(n)
     * space: O(1)
     * @param s
     * @return
     */

    public static int firstUniqChar(String s) {


        if(s == null || s.length() == 0){
            return -1;
        }


        int[] counts = new int[26];
        for(int i = 0; i < s.length(); i++){
            counts[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < s.length(); i++){
            if(counts[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }
}
