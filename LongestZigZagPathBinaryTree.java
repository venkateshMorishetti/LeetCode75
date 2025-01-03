/**

    You are given the root of a binary tree.

    A ZigZag path for a binary tree is defined as follow:

    Choose any node in the binary tree and a direction (right or left).
    If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
    Change the direction from right to left or from left to right.
    Repeat the second and third steps until you can't move in the tree.
    Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).

    Return the longest ZigZag path contained in that tree.

    Example 1:
    Input: root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1]
    Output: 3
    Explanation: Longest ZigZag path in blue nodes (right -> left -> right).

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

///bruteforce
class Solution {
    int result = 0;
    public int longestZigZag(TreeNode root) {
        if(root == null){
            return result;
        }
        longestZigZagPath(root, "left", 0);
        longestZigZagPath(root, "right", 0);
        
        longestZigZag(root.left);
        longestZigZag(root.right);

        return result-1;

    }

    public void longestZigZagPath(TreeNode root, String previousDirection, int pathCount){
        if(root == null){
            if(pathCount > result){
                result = pathCount;
            }
            return;
        }

        if(previousDirection.equals("left")){
            longestZigZagPath(root.right, "right", pathCount+1);
        }
        else if(previousDirection.equals("right")){
            longestZigZagPath(root.left, "left", pathCount+1);
        }
    }

}



///////

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
    public int longestZigZag(TreeNode root) {
        if(root == null){
            return result;
        }
        longestZigZagPath(root, 0, 0);

        return result-1;

    }

    public void longestZigZagPath(TreeNode root, int leftPath, int rightPath){
        if(root == null){
            if(leftPath > rightPath ){
                if(leftPath > result)
                    result = leftPath;
            } else{
                if(rightPath > result)
                    result = rightPath;
            }
            return;
        }

        longestZigZagPath(root.right, rightPath+1, 0);
        longestZigZagPath(root.left, 0, leftPath+1);
    }

}