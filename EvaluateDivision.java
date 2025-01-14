/**
 You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.

You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.

Return the answers to all queries. If a single answer cannot be determined, return -1.0.

Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.

Note: The variables that do not occur in the list of equations are undefined, so the answer cannot be determined for them.

 

Example 1:

Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation: 
Given: a / b = 2.0, b / c = 3.0
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? 
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
note: x is undefined => -1.0

Example 2:

Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
Output: [3.75000,0.40000,5.00000,0.20000]
Example 3:

Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
Output: [0.50000,2.00000,-1.00000,-1.00000]
 */



class Solution {
    // double ans = 1;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> graph = new HashMap();

        double[] result = new double[queries.size()];

        for(int i = 0; i < equations.size(); i++){
            List<String> edge = equations.get(i);

            if(!graph.containsKey(edge.get(0))){
                graph.put(edge.get(0), new HashMap<String, Double>());
            }

             if(!graph.containsKey(edge.get(1))){
                graph.put(edge.get(1), new HashMap<String, Double>());
            }
            HashMap<String, Double> mapAtNode0 = graph.get(edge.get(0));
            HashMap<String, Double> mapAtNode1 = graph.get(edge.get(1));

            mapAtNode0.put(edge.get(1), values[i]);
            mapAtNode1.put(edge.get(0), 1/values[i]);
            
            graph.put(edge.get(0),mapAtNode0);
            graph.put(edge.get(1),mapAtNode1);
        }

        for(int i= 0; i < queries.size(); i++){
            List<String> query = queries.get(i);
            Set<String> visited = new HashSet<>();
            double[] ans = new double[1]; 
            ans[0] = 1.0;
            if(!graph.containsKey(query.get(0)) || !graph.containsKey(query.get(1))){
                result[i] = -1;
            } else {
                if(dfs(query.get(0), query.get(1), graph,visited, ans)){
                    result[i] = ans[0];
                } else {
                    result[i] = -1;
                }
                
            }   
        }
        return result;
    }


    public boolean dfs(String currentNode, String dest,HashMap<String, HashMap<String, Double>> graph, Set<String> visited, double[] ans){
        if(currentNode.equals(dest)){
            return true;
        }

        // double ans = 1;
        visited.add(currentNode);
        boolean foundDest = false;
        HashMap<String, Double> mapAtCurrentNode = graph.get(currentNode);
        if(mapAtCurrentNode != null){
            for(String neighbourNode: mapAtCurrentNode.keySet()){
                if(!visited.contains(neighbourNode)){
                    
                    if(dfs(neighbourNode, dest,graph, visited, ans)){
                        ans[0] *= mapAtCurrentNode.get(neighbourNode);
                        foundDest = true;
                        break;
                    }
                }
            }
        }
 

        return foundDest;
    }
}