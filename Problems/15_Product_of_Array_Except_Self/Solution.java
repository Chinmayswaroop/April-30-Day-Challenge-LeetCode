/* 
Problem :: 

Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:
Input:  [1,2,3,4]
Output: [24,12,8,6]
Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(n)
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int size = nums.length;
        int [] result = new int[size];
        
        result[size-1]=1;
        int prev=nums[size-1];
        for(int j=size-2;j>=0;j--){
            result[j]= result[j+1]*prev;
            prev=nums[j];
        }

        prev=1;
        for(int j=1;j<size;j++){
            int temp = prev*nums[j-1];
            result[j] = result[j]*temp;
            prev = temp;
        }
        
        return result;
        
    }
}