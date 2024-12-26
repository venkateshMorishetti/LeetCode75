class Solution {
    public String gcdOfStrings(String str1, String str2) {

        String minStr = str1.length() > str2.length() ? str2: str1;
        String maxStr = str1.length() > str2.length() ? str1: str2;

        if(str1.equals(str2)){
            return str1;
        }

        if(!maxStr.startsWith(minStr)){
            return "";
        }

        return gcdOfStrings(maxStr.substring(minStr.length()),minStr);
    }
}