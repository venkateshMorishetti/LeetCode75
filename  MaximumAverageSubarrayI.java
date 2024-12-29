/**
    You are given an integer array nums consisting of n elements, and an integer k.

    Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.

    

    Example 1:

    Input: nums = [1,12,-5,-6,50,3], k = 4
    Output: 12.75000
    Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
    Example 2:

    Input: nums = [5], k = 1
    Output: 5.00000
 */

 class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double result = Integer.MIN_VALUE;
        int sum = 0, i=1, j = i+k;
        //caluclate the sum of first k elements
        for(int l=0; l<k; l++){
            sum += nums[l];
        }

        double t = (sum*1.0)/k;
        
        if(t> result){
            result = t;
        }

        while(j <= nums.length){
            //subtract excluded element
            sum = sum-nums[i-1];
            //add included element
            sum =sum+nums[j-1];
            t = (sum*1.0)/k;
            if(t> result){
                result = t;
            }

            i++;
            j++;

        }
        return result;
        
    }
}
