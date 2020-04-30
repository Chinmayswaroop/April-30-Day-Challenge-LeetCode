/* 
Problem :: 
Return the root node of a binary search tree that matches the given preorder traversal.
(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.

Example 1:
Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]
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
    int index=0;
    public TreeNode helper(int [] preorder, Map<Integer,Integer> store, int start, int end){
        if(start>end)
            return null;
        
        TreeNode node = new TreeNode(preorder[index++]);
        if(start==end)
            return node;
        
        int i = store.get(node.val);
        node.left = helper(preorder, store, start, i-1);
        node.right = helper(preorder, store, i+1, end);
        return node;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        
        int size = preorder.length;
        int [] inorder = Arrays.copyOf(preorder,size);
        Arrays.sort(inorder);
        Map<Integer,Integer> store  = new HashMap<>();
        for(int i=0;i<size ;i++){
            store.put(inorder[i], i);
        }
        return helper(preorder, store, 0, preorder.length-1);
    }
}



class Solution {
    int index=0;
    public TreeNode helper(int [] A, int bound){
       if(index ==A.length || A[index] > bound){
           return null;
       }
       TreeNode node = new TreeNode(A[index++]);
       node.left = helper(A,node.val);
       node.right = helper(A, bound);
                System.out.println(node.val);
        return node;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, Integer.MAX_VALUE);
    }
}