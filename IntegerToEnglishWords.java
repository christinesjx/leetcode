/**
 *
 * 273
 *
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
 *
 * Example 1:
 *
 * Input: 123
 * Output: "One Hundred Twenty Three"
 * Example 2:
 *
 * Input: 12345
 * Output: "Twelve Thousand Three Hundred Forty Five"
 * Example 3:
 *
 * Input: 1234567
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * Example 4:
 *
 * Input: 1234567891
 * Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 */
public class IntegerToEnglishWords {


    String[] less20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};


    public String integerToEnglishWords(int num){

        if(num == 0){
            return "Zero";
        }
        String result = "";
        int i = 0;

        while(num > 0){
            if(num % 1000 != 0){
                result = helper(num % 1000) + thousands[i] + " "+ result;
            }
            num /= 1000;
            i++;
        }
        return result.trim();

    }

    public String helper(int num){
        if(num == 0){
            return "";
        }
        if(num < 20){
            return less20[num] + " ";
        }else if (num < 100){
            return tens[num / 10] + " " + helper(num % 10);
        }else{
            return less20[num / 100] + " Hundred " + helper(num % 100);
        }

    }

    public static void main(String[] args) {

        IntegerToEnglishWords main = new IntegerToEnglishWords();
        System.out.println(main.integerToEnglishWords(1234567));
    }
}
