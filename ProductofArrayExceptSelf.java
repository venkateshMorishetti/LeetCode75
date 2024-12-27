/**
    Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

    You must write an algorithm that runs in O(n) time and without using the division operation.

    

    Example 1:

    Input: nums = [1,2,3,4]
    Output: [24,12,8,6]
    Example 2:

    Input: nums = [-1,1,0,-3,3]
    Output: [0,0,9,0,0]

 */

//divide solution
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int c = 0;
        int p = 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                c++;
            }else{
                p *= nums[i];
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(c >1){
                nums[i] = 0;
            } else if(c == 1){
                if(nums[i] == 0){
                    nums[i] = p;
                } else {
                    nums[i] = 0;
                }
            }else{
                nums[i] = p/nums[i];
            }
        }

        return nums;
    }
}

//alternative solution
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] left_prefix_array = new int[size];
        int[] right_prefix_array = new int[size];
        int pr = 1;
        for(int i = 0; i < size; i++){
            left_prefix_array[i] = pr;
            pr = pr * nums[i];
        }

        pr = 1;
        for(int i = size-1; i >= 0; i--){
            right_prefix_array[i] = pr;
            pr = pr*nums[i];
        }

        for(int i = 0; i < size; i++){
            nums[i] = right_prefix_array[i]*left_prefix_array[i];
        }

        return nums;
    }
}

