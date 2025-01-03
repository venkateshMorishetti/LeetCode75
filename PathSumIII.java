/**
    Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
    The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).

    Example 1:
    Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
    Output: 3
    Explanation: The paths that sum to 8 are shown.
    Example 2:

    Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
    Output: 3
 */


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */



class Solution {
    int result = 0;
    public int pathSum(TreeNode root, int targetSum) {
        preOrder(root, targetSum, 0);
        return result;
    }

    public void preOrder(TreeNode root, int targetSum, long sumtillNow ){
        if(root == null){
            return;
        }
        findPaths(root, targetSum, sumtillNow);
        preOrder(root.left,  targetSum, sumtillNow);
        preOrder(root.right,  targetSum, sumtillNow);
    }

    public void findPaths(TreeNode root, int targetSum, long sumtillNow){
        if(root == null){
            return;
        }
       sumtillNow += root.val;
       if(sumtillNow == targetSum){
        result++;
       }
        findPaths(root.left,targetSum, sumtillNow);
        findPaths(root.right,targetSum, sumtillNow);

    }
}