import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] arr, int source, int destination) {
        
        if(source == destination) return true;
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge : arr){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        
        q.add(source);
        visited[source] = true;
        
        while(!q.isEmpty()){
            int node = q.poll();
            
            for(int neighbor : graph.get(node)){
                if(!visited[neighbor]){
                    if(neighbor == destination)
                        return true;
                    
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
        
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        
        Solution sol = new Solution();
        
        int n = 3;
        int[][] arr = {
            {0,1},
            {1,2},
            {2,0}
        };
        
        int source = 0;
        int destination = 2;
        
        boolean result = sol.validPath(n, arr, source, destination);
        
        System.out.println(result);
    }
}
