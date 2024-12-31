/**

    Given an encoded string, return its decoded string.

    The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

    You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

    The test cases are generated so that the length of the output will never exceed 105.

    

    Example 1:

    Input: s = "3[a]2[bc]"
    Output: "aaabcbc"
    Example 2:

    Input: s = "3[a2[c]]"
    Output: "accaccacc"
    Example 3:

    Input: s = "2[abc]3[cd]ef"
    Output: "abcabccdcdcdef"

 */

 class Solution {
    public String decodeString(String s) {

        Stack<String> st = new Stack();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != ']'){
                st.push(s.charAt(i)+"");
            } else{
                String r="";

                while(!st.peek().equals("[")){
                    r =  st.pop()+r;
                }
                // System.out.println("string is "+r);
                // System.out.println("stack "+st);
                st.pop();
                //count 
                String c = "";
                while(st.size()!=0 && st.peek().matches("-?\\d+")){
                    c = st.pop()+c;
                }
                int t = Integer.parseInt(c);
                // System.out.println("c is "+t);
                String f = "";
                for(int a = 0; a < t; a++){
                    f = f+r;
                }
                st.push(f);
            }
        }
        return st.stream().collect(Collectors.joining(""));
    }


}
