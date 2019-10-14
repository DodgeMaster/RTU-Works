package LaboratoryWork_2;

public class Solution {
    public static void main(String[] args) {
        System.out.println(superDigit(1001));
        System.out.println(isPalindrome("level"));
    }

    static long superDigit(long n){
        if(n / 10 == 0){
            return (n);
        } else {
            return  ((n % 10) + superDigit(n / 10));
        }
    }

    static boolean isPalindrome(String symbols) {
        String word = symbols.toLowerCase();
        if((word.length()==0) || (word.length() == 1))
            return true;

        else{
            char first = word.charAt(0);
            char last = word.charAt(word.length() - 1);
            if(first != last){
                return false;
            } else{
                String s = word.substring(1,word.length()-1);
                return (isPalindrome(s));
            }
        }
    }
}
