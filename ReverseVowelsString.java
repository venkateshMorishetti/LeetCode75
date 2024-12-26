
/**
    Given a string s, reverse only all the vowels in the string and return it.
    The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
    Example 1:

    Input: s = "IceCreAm"

    Output: "AceCreIm"

    Explanation:

    The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".
 */


//solution-1
class Solution {
    public String reverseVowels(String s) {
        int startIndex = 0, lastIndex = s.length()-1;
       
        String[] sArray = s.split("");
        while(startIndex < lastIndex){
            String currentChar = sArray[startIndex].toLowerCase();
            if(currentChar.equals("a") || currentChar.equals("e") || currentChar.equals("i") || currentChar.equals("o") || currentChar.equals("u")){

                lastIndex = getLastVowelIndex(sArray, startIndex, lastIndex);
                if(lastIndex != -1){
                    String t = sArray[lastIndex];
                    sArray[lastIndex] = sArray[startIndex];
                    sArray[startIndex] = t;
                    lastIndex--;
                }
            }
           startIndex++; 
        }

        return Arrays.toString(sArray).replaceAll(", ", "").replace("[", "").replace("]", "");


    }

    public int getLastVowelIndex(String[] sArray, int startIndex, int endIndex){
        for(int i = endIndex; i > startIndex; i--){
             String currentChar = sArray[i].toLowerCase();
            if(currentChar.equals("a") || currentChar.equals("e") || currentChar.equals("i") || currentChar.equals("o") || currentChar.equals("u")){
                return i;
            }
        }
        return -1;
    }
}


//solution-2


class Solution {

    public boolean isVowel(char c){
        return (c == 'a' || c == 'A' || c == 'e'
                || c == 'E' || c == 'i' || c == 'I'
                || c == 'o' || c == 'O' || c == 'u'
                || c == 'U');
    }
    public String reverseVowels(String s) {
        char[] cArray = s.toCharArray();
        String vowels = "";
        int j = 0;

         //store all vowels
        for(int i = 0; i < cArray.length; i++){
            if(isVowel(cArray[i])){
                vowels+= cArray[i];
                j++;
            }
        }
        for(int i= 0; i < cArray.length; i++){
            if(isVowel(cArray[i])){
                cArray[i] =  vowels.charAt(j-1);
                j--;
            }
        }
        return String.valueOf(cArray);
    }
}