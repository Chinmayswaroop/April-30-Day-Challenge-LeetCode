/* 
Problem :: 
Given a binary tree where each path going from the root to any leaf form a valid sequence, check if a given string is a valid sequence in such binary tree. 

We get the given string from the concatenation of an array of integers arr and the concatenation of all values of the nodes along a path results in a sequence in the given binary tree.

Example 1:

Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,0,1]
Output: true
Explanation: 
The path 0 -> 1 -> 0 -> 1 is a valid sequence (green color in the figure). 
Other valid sequences are: 
0 -> 1 -> 1 -> 0 
0 -> 0 -> 0
Example 2:



Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,0,1]
Output: false 
Explanation: The path 0 -> 0 -> 1 does not exist, therefore it is not even a sequence.
Example 3:



Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,1]
Output: false
Explanation: The path 0 -> 1 -> 1 is a sequence, but it is not a valid sequence.
 

Constraints:

1 <= arr.length <= 5000
0 <= arr[i] <= 9
Each node's value is between [0 - 9].
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
    
    private boolean dfs(TreeNode root, int [] arr, int index){
        
        if(root.left==null && root.right ==null ){
            if(index+1==arr.length)
                return true;
            else
                return false;
        }
        
        boolean left= false;
        boolean right = false;
        
        if(index+1< arr.length && root.left!=null && root.left.val == arr[index+1])
             left = dfs(root.left, arr, index+1);
        
        if(index+1< arr.length && root.right!=null && root.right.val == arr[index+1])
             right = dfs(root.right, arr, index+1);
        
        return left || right;
        
    }
    public boolean isValidSequence(TreeNode root, int[] arr) {
        
        if(root.val != arr[0])
            return false;
        return dfs(root, arr, 0);
    }
}