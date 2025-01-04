/**
    Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

    Basically, the deletion can be divided into two stages:

    Search for a node to remove.
    If the node is found, delete the node.
    

    Example 1:
    Input: root = [5,3,6,2,4,null,7], key = 3
    Output: [5,4,6,2,null,null,7]
    Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
    One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
    Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.

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
    public TreeNode deleteNode(TreeNode root, int key) {

        if(root == null){
            return root;
        }

        if(root.val > key){
            root.left = deleteNode(root.left, key);
        }
        else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }else{
            if(root.left == null){
                return root.right;
            } 
            if(root.right == null){
                return root.left;
            } 
                //take right side subtree and find the minimum element in right sub tree
            TreeNode min = getSuccessor(root);
            root.val = min.val;
            root.right = deleteNode(root.right, min.val);
        }
        return root;
    }

    public TreeNode getSuccessor(TreeNode curr){
        curr = curr.right;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }
}
