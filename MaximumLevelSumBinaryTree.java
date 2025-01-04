/**
    Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
    Return the smallest level x such that the sum of all the values of nodes at level x is maximal.

    Example 1:
    Input: root = [1,7,0,7,-8,null,null]
    Output: 2
    Explanation: 
    Level 1 sum = 1.
    Level 2 sum = 7 + 0 = 7.
    Level 3 sum = 7 + -8 = -1.
    So we return the level with the maximum sum which is level 2.
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
    public int maxLevelSum(TreeNode root) {
        if(root == null){
            return -1;
        }
        int result = Integer.MIN_VALUE;
        int resultLevel = -1;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        int currentLevel = 1;
        while(!q.isEmpty()){
            int currentLevelSum = 0;
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode currentNode = q.remove();
                currentLevelSum += currentNode.val;

                if(currentNode.left != null){
                    q.add(currentNode.left);
                }

                if(currentNode.right != null){
                    q.add(currentNode.right);
                }
            }

            if(currentLevelSum > result){
                result = currentLevelSum;
                resultLevel = currentLevel;
            }
            currentLevel++;
        }

        return resultLevel;

        
    }
}