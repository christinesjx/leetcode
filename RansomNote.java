/*
Given an arbitrary ransom note string and another string containing letters from all the magazines,
write a function that will return true if the ransom note can be constructed from the magazines ;
otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true

*/


public class RansomNote {

    /**
     * bitmap
     * time: O(n)
     * space: O(1)
     * @param ransomNote
     * @param magazine
     * @return
     */

    public static boolean canConstruct(String ransomNote, String magazine) {


        if(ransomNote == null || ransomNote.length() == 0){
            return true;
        }
        if(magazine == null || magazine.length() == 0){
            return false;
        }


        int[] counts = new int[26];
        for(int i = 0; i < magazine.length(); i++){
            counts[magazine.charAt(i) - 'a']++;
        }

        for(int i = 0; i < ransomNote.length(); i++){

            if(counts[ransomNote.charAt(i) - 'a'] == 0){
                return false;
            }else{
                counts[ransomNote.charAt(i) - 'a']--;
            }

        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(canConstruct("fihjjjjei","hjibagacbhadfaefdjaeaebgi"));
    }
}


