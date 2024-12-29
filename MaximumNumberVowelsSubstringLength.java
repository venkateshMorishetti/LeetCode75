/**
    Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

    Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

    

    Example 1:

    Input: s = "abciiidef", k = 3
    Output: 3
    Explanation: The substring "iii" contains 3 vowel letters.
    Example 2:

    Input: s = "aeiou", k = 2
    Output: 2
    Explanation: Any substring of length 2 contains 2 vowels.
    Example 3:

    Input: s = "leetcode", k = 3
    Output: 2
    Explanation: "lee", "eet" and "ode" contain 2 vowels.
 */

 class Solution {
    public int maxVowels(String s, int k) {

        int i= 0, j = i+k, result =0;;

        while(j <= s.length()){
            String substr = s.substring(i, j);
            String updatedSubstr = substr.replaceAll("[^aeiouAEIOU]", "");
            if(result < updatedSubstr.length()){
                result = updatedSubstr.length();
            }
            i++;
            j++;
            
        }

        return result;
        
    }
}


class Solution {
    public int maxVowels(String s, int k) {
        int i= 1, j = i+k, result =0;
        //caluclate the vowels count for first substring 
        int c = 0;
        for(int l=0; l<k; l++){
            if(s.charAt(l)=='a' || s.charAt(l)=='e' || s.charAt(l)=='i' || s.charAt(l)=='o' || s.charAt(l)=='u'){
                c++;
            }
        }
        if(result < c){
            result = c;
        }
        while(j-1 < s.length()){
            //incoming character
            if(s.charAt(j-1)=='a' || s.charAt(j-1)=='e' || s.charAt(j-1)=='i' || s.charAt(j-1)=='o' || s.charAt(j-1)=='u'){
                c++;
            }
            //excluded character
            if(s.charAt(i-1)=='a' || s.charAt(i-1)=='e' || s.charAt(i-1)=='i' || s.charAt(i-1)=='o' || s.charAt(i-1)=='u'){
                c--;
            }
            if(c > result){
                result = c;
            }
            i++;
            j++;
            
        }

        return result;
        
    }
}