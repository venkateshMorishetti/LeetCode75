/**
    Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.

    A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).

    Example 1:
    Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
    Output: 1
    Explanation: There is 1 equal row and column pair:
    - (Row 2, Column 1): [2,7,7]
 */

 class Solution {
    public int equalPairs(int[][] grid) {

        int size = grid.length;
        int count =0;
        for(int i=0; i < size; i++){

            int[] rowArray = grid[i];
            //iterating column wise
            for(int j=0; j < size; j++){
                int index = 0;
                boolean check = true;
                for(int k = 0; k < size; k++){
                    if(rowArray[index++] != grid[k][j]){
                        check = false;
                        break;
                    }
                }

                if(check){
                    count++;
                }
                
            }
        }

        return count;
          
        
    }
}