/**
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.


 */



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 //brute force

class Solution {
    ArrayList<Integer> p1 = new ArrayList();
    ArrayList<Integer> p2 = new ArrayList();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        findPath(root, p.val, p1);
        findPath(root, q.val, p2);
        int i;
        for(i = 0; i<p1.size() &&
                     i<p2.size(); i++) {
            String v1= p1.get(i)+"";
            String v2 = p2.get(i)+"";
            if(!v1.equals(v2)){
                TreeNode result = new TreeNode(p1.get(i-1));
                return result;
            }
        }
        TreeNode result = new TreeNode(p1.get(i-1));
        return result;
        
    }

    public boolean findPath(TreeNode root, int target, ArrayList<Integer> path){
        if(root == null){
            return false;
        } 
        path.add(root.val);
        if(root.val == target){
            return true;
        }
        boolean leftFound = findPath(root.left, target, path);
        boolean rightFound = findPath(root.right, target, path);

        if(leftFound || rightFound){
            return true;
        } else{
            path.remove(path.size()-1);
            return false;
        }


    }
}


// o(n) approach

class Solution {
   
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        int r = findAncestor(root, p.val, q.val);
        TreeNode result = new TreeNode(r);
        return result;
        
    }

    public int findAncestor(TreeNode root, int p, int q){
        if(root == null){
            return -1;
        }

        if(root.val == p ){
            return p;
        }
        if(root.val == q){
            return q;
        }

        int leftFound = findAncestor(root.left, p, q);
        int rightFound = findAncestor(root.right, p, q);
        if(leftFound != -1 && rightFound != -1){
            return root.val;
        } else if(leftFound != -1 && rightFound == -1){
            return leftFound;
        }else {
            return rightFound;
        }
    }


}
