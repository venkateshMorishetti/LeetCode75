/**
    Given a binary array nums, you should delete one element from it.

    Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.

    

    Example 1:

    Input: nums = [1,1,0,1]
    Output: 3
    Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
    Example 2:

    Input: nums = [0,1,1,1,0,1,1,0,1]
    Output: 5
    Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
 */




class Solution {
    public int longestSubarray(int[] nums) {

        int left = 0, right = 0, deleted_zeros = 0, window_size = 0;

        while(right < nums.length){
            if(nums[right] == 0){
                deleted_zeros++;
            }

            while(deleted_zeros > 1){

                if(nums[left] == 0){
                    deleted_zeros--;
                }
                left++;
            }

            int s = right-left;
            if(s > window_size){
                window_size = s;
            }

            right++;
        }

        return window_size;
        
    }
}