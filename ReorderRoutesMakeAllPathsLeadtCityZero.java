/**

There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.

Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.

This year, there will be a big event in the capital (city 0), and many people want to travel to this city.

Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.

It's guaranteed that each city can reach city 0 after reorder.

Example 1:

Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
Output: 3
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).

 */

 class Solution {

    public int minReorder(int n, int[][] connections) {
        boolean[] visited = new boolean[n];

        Map<Integer, ArrayList<Integer>> originalGraph = new HashMap();

        Map<Integer, ArrayList<Integer>> graph = new HashMap();
        //compute graph
        for(int i = 0; i < connections.length; i++){
            int[] edge = connections[i];
            int fromCity = edge[0], toCity = edge[1];

            if(graph.containsKey(fromCity)){
                ArrayList<Integer> cities =  graph.get(fromCity);
                cities.add(toCity);
                graph.put(fromCity,cities);
            } else {
                ArrayList<Integer> cities =  new ArrayList();
                cities.add(toCity);
                graph.put(fromCity, cities);
            }

            if(originalGraph.containsKey(fromCity)){
                ArrayList<Integer> cities =  originalGraph.get(fromCity);
                cities.add(toCity);
                originalGraph.put(fromCity,cities);
            } else {
                ArrayList<Integer> cities =  new ArrayList();
                cities.add(toCity);
                originalGraph.put(fromCity, cities);
            }
            // originalGraph[fromCity][toCity] = 1; 

            if(graph.containsKey(toCity)){
                ArrayList<Integer> cities =  graph.get(toCity);
                cities.add(fromCity);
                graph.put(toCity, cities);
            } else {
                ArrayList<Integer> cities =  new ArrayList();
                cities.add(fromCity);
                graph.put(toCity, cities);
            }
        }
        
        return dfs(0, visited, originalGraph, graph);
        
    }


    private int dfs(int currentNode, boolean[] visited, Map<Integer, ArrayList<Integer>> originalGraph, Map<Integer, ArrayList<Integer>> graph){
        visited[currentNode] = true;
        int ans =0;
        for(int neighbourNode: graph.get(currentNode)){
            if(!visited[neighbourNode]){
                if(originalGraph.get(currentNode)!= null && originalGraph.get(currentNode).indexOf(neighbourNode)>-1){
                    ans++; 
                }
                ans += dfs(neighbourNode,visited, originalGraph, graph);
            }
        }

        return ans;
    }
}