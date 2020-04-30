/* 
Problem :: 

Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4

*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(n)
*/
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length==0)
            return 0;
        int row = matrix.length+1;
        int col = matrix[0].length+1;
        int [][] dp = new int[row][col];
        
        int maxSize = 0;       
        for(int i=1;i<row;i++){
            for(int j=1; j<col; j++){
                if( matrix[i-1][j-1]=='1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]),dp[i][j-1])+1;
                    maxSize = Math.max(maxSize, dp[i][j]);
                }
            }
        }
     return maxSize * maxSize;
    }
}
