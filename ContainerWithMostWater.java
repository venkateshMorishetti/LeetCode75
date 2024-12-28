/**
 
    You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

    Find two lines that together with the x-axis form a container, such that the container contains the most water.

    Return the maximum amount of water a container can store.

    Notice that you may not slant the container.

    Example 1:
    Input: height = [1,8,6,2,5,4,8,3,7]
    Output: 49
    Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

 */


 class Solution {
    public int maxArea(int[] height) {
        //[1,3,4,5,2,6]
        int size = height.length;
        int storedWater = 0;
        for(int i = 0; i < size; i++){
            for(int j = i+1; j < size; j++){
                int minheight = Math.min(height[i], height[j]);
                int stored = (j-i)*minheight;

                if(storedWater < stored){
                    storedWater = stored;
                }
            }
        }

        return storedWater;

    }
}


class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int storedWater = 0;
        while(left < right){
            int left_side_height = height[left];
            int right_side_height = height[right];
            int width = right-left;
            int storage = width*Math.min(left_side_height, right_side_height);
            if(storage > storedWater){
                storedWater = storage;
            }

            if(left_side_height <= right_side_height){
                left++;
            } else{
                right--;
            }
            
        }
        return storedWater; 
    }
}