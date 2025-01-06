/**

There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.

Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2

 */

 class Solution {
    int[][] isConnected;
    boolean[] visited;
    int res = 0;
    public int findCircleNum(int[][] isConnected) {
        this.isConnected = isConnected;
        int nodes = isConnected.length;
        visited = new boolean[nodes];

        for(int i = 0; i < nodes; i++){
            if(!visited[i]){
                dfs(i);
                res++;
            }
        }

        return res;
    }

    public void dfs(int n){
        this.visited[n] = true;
        int[] adjecentNodes = this.isConnected[n];
        for(int i = 0; i < adjecentNodes.length; i++){
            if(adjecentNodes[i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }
}