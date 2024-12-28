/**
    You are given an integer array nums and an integer k.

    In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

    Return the maximum number of operations you can perform on the array.

    

    Example 1:

    Input: nums = [1,2,3,4], k = 5
    Output: 2
    Explanation: Starting with nums = [1,2,3,4]:
    - Remove numbers 1 and 4, then nums = [2,3]
    - Remove numbers 2 and 3, then nums = []
    There are no more pairs that sum up to 5, hence a total of 2 operations.

 */

 class Solution {
    public int maxOperations(int[] nums, int k) {
        int count = 0;
        boolean[] valid= new boolean[nums.length];
        for(int i = 0; i < nums.length-1; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i]+ nums[j] == k && !valid[i] && !valid[j]){
                    count++;
                    valid[i] = true;
                    valid[j] = true;
                }
            }
        }

        return count;
    }
}


class Solution {
    public int maxOperations(int[] nums, int k) {
        int count = 0;
        Arrays.sort(nums);
        int low =0, high = nums.length-1;
        while(low< high){
            int currentSum = nums[low]+nums[high];
            if(currentSum > k){
                high--;
            } else if(currentSum < k){
                low++;
            } else {
                count++;
                low++;
                high--;
            }
        }

        return count;
    }
}