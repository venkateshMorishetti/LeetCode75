/**
You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+'). You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column of the cell you are initially standing at.

In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot step outside the maze. Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell that is at the border of the maze. The entrance does not count as an exit.

Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.

Example 1:

Input: maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]], entrance = [1,2]
Output: 1
Explanation: There are 3 exits in this maze at [1,0], [0,2], and [2,3].
Initially, you are at the entrance cell [1,2].
- You can reach [1,0] by moving 2 steps left.
- You can reach [0,2] by moving 1 step up.
It is impossible to reach [2,3] from the entrance.
Thus, the nearest exit is [0,2], which is 1 step away.

 */

 class Solution {
    class Cell{
        int rowIndex, colIndex;
        Cell(int i,int j){
            rowIndex = i;
            colIndex = j; 
        }

        public String toString(){
            return "{"+rowIndex+","+colIndex+"}";
        }
    }
    public int nearestExit(char[][] maze, int[] entrance) {
        int rowCount = maze.length;
        int colCount = maze[0].length;
        boolean[][] visited = new boolean[rowCount][colCount];
        Queue<Cell> q = new LinkedList<>();

        q.add(new Cell(entrance[0], entrance[1]));

        visited[entrance[0]][entrance[1]] = true;

        int result = 0;
        boolean exitFound = false;
        while(!q.isEmpty()){
           
            result++;

            int qSize = q.size();

            for(int i = 0; i < qSize; i++){
                Cell cell = q.poll();
                            //check up cell
            if(cell.rowIndex-1 >=0 && maze[cell.rowIndex-1][cell.colIndex] == '.' && !visited[cell.rowIndex-1][cell.colIndex]){
                visited[cell.rowIndex-1][cell.colIndex] = true;
                //check is it border cell or not
                if(cell.rowIndex-1 == 0 || cell.rowIndex-1 == rowCount-1 || cell.colIndex == 0 || cell.colIndex == colCount-1){
                   return result;
                }
                q.add(new Cell(cell.rowIndex-1,cell.colIndex));
            }

            //check left cell
            if(cell.colIndex-1 >= 0 && maze[cell.rowIndex][cell.colIndex-1] == '.' && !visited[cell.rowIndex][cell.colIndex-1]){
                visited[cell.rowIndex][cell.colIndex-1] = true;
                //check is it border cell or not
                if(cell.colIndex-1 == 0 || cell.colIndex-1 == colCount-1 || cell.rowIndex == 0 || cell.rowIndex == rowCount-1){
                   return result;
                }
                q.add(new Cell(cell.rowIndex,cell.colIndex-1));
            }

            //check right cell
            if(cell.colIndex+1 < colCount && maze[cell.rowIndex][cell.colIndex+1] == '.' && !visited[cell.rowIndex][cell.colIndex+1]){
                visited[cell.rowIndex][cell.colIndex+1] = true;
                //check is it border cell or not
                if(cell.colIndex+1 == colCount-1 || cell.colIndex+1 == 0  || cell.rowIndex == 0 || cell.rowIndex == rowCount-1){
                   return result; 
                }
                q.add(new Cell(cell.rowIndex,cell.colIndex+1));
            }

            //check down cell
             if(cell.rowIndex+1 < rowCount && maze[cell.rowIndex+1][cell.colIndex] == '.' && !visited[cell.rowIndex+1][cell.colIndex]){
                visited[cell.rowIndex+1][cell.colIndex] = true;
                 //check is it border cell or not
                if(cell.rowIndex+1 == rowCount-1  || cell.rowIndex+1 == 0 || cell.colIndex == 0 || cell.colIndex == colCount-1){
                    return result;
                }
                q.add(new Cell(cell.rowIndex+1,cell.colIndex));
            }
            }
        }

        return  -1; 
        
    }
}