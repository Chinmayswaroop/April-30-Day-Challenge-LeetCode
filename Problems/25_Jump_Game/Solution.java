/* 
Problem :: 
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 

Constraints:

1 <= nums.length <= 3 * 10^4
0 <= nums[i][j] <= 10^5

*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(n)
*/

class Solution {
    /* consider this example 
    array :: 1,1,2,5,2,1,0,0,1,3 true
    array :: 1,1,2,3,2,1,0,0,1,3 false
    */
    public boolean canJump(int[] nums) {
       /* soultion 1 by reachable (hill and valley conept) */
       int reachable =0;
       for(int i=0;i<nums.length;i++){
           if(i>reachable)
               return false;
           reachable = Math.max(reachable, nums[i]+i);
       }
      return true;
    }
    
     public boolean canJump(int[] nums) {
       /* soultion 1 by reachable (hill and valley conept) */
       int size = nums.length;
       int posi =size-1; /* as we have to reach till last index */
       for(int i=size-1;i>=0;i--){
           if(i+nums[i]>=posi)
               posi = i;
       }
      return posi==0;
    }
}