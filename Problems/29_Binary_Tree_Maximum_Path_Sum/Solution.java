/* 
Problem :: 
Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42
*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(n)
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
class Solution {
    int sum = Integer.MIN_VALUE;
    private int helper(TreeNode root){
        if(root==null) return 0;
        
        int left = helper(root.left);
        int right = helper(root.right);
        int maxLeftRight = Math.max(left,right); /* bigger of left or right */
        
        int maxAtRoot = Math.max(Math.max(left+right+root.val,root.val),root.val+maxLeftRight);
        sum = Math.max(sum,maxAtRoot);        
        return Math.max(root.val+maxLeftRight, root.val);
    
    }
    
    public int maxPathSum(TreeNode root) {
        helper(root);
        return sum;   
    }
}
