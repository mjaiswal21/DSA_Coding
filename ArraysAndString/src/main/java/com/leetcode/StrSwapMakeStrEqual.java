package ArraysAndString.src.main.java.com.leetcode;

//https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/description/
//1790. Check if One String Swap Can Make Strings Equal

/*
You are given two strings s1 and s2 of equal length. A string swap is an operation where you choose two
indices in a string (not necessarily different) and swap the characters at these indices.

Return true if it is possible to make both strings equal by performing at most one string swap on exactly
one of the strings. Otherwise, return false.



Example 1:

Input: s1 = "bank", s2 = "kanb"
Output: true
Explanation: For example, swap the first character with the last character of s2 to make "bank".
 */

public class StrSwapMakeStrEqual {
    public boolean areAlmostEqual(String s1, String s2) {

        int idx1 = 0;
        int idx2 = 0;
        int count = 0;
        for(int i = 0 ; i < s1.length(); i++){

            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);

            if(ch1 != ch2){
                count++;
                if(count > 2){
                    return false;
                }else if(count == 1){
                    idx1 = i;
                }else{
                    idx2 = i;
                }
            }
        }

        return s1.charAt(idx1) == s2.charAt(idx2) && s1.charAt(idx2) == s2.charAt(idx1);

    }

    public static void main(String[] args) {
       String s1 = "bank";
       String s2 = "kanb";
        StrSwapMakeStrEqual strEqual = new StrSwapMakeStrEqual();
        boolean ans = strEqual.areAlmostEqual(s1 , s2);
        System.out.println("  "+ans+" ");
    }
}
