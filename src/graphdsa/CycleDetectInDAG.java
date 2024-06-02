/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphdsa;

import java.util.ArrayList;

/**
 *
 * @author PANDIT
 */
public class CycleDetectInDAG {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=4; i++){
            adj.add(new ArrayList<>());
        }
        
        addEdge(adj, 4, 4);
        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 3);
//        addEdge(adj, 1, 0);
//        addEdge(adj, 7, 5);s
//        addEdge(adj, 8, 2);
//        addEdge(adj, 8, 9);
//        addEdge(adj, 9, 10);
//        addEdge(adj, 10, 8);
        
        System.out.println("adj=="+adj);
        
        int[] path = new int[11];
        int[] pathVis = new int[11];
        for(int i=0; i<path.length; i++){
            path[i] = 0;
            pathVis[i] = 0;
        }
        
        System.out.println("isCycle == "+isCycle(adj, path, pathVis));
    }
    
    static boolean isCycle(ArrayList<ArrayList<Integer>> adj, int[] vis, int[] pathVis){
        for(int i=0; i<adj.size(); i++){
            if(detectCycle(adj, i, vis, pathVis) == true){
                return true;
            }
        }
        return false;
    }
    
    static boolean detectCycle(ArrayList<ArrayList<Integer>> adj, int node, int[] vis, int[] pathVis){
        vis[node] = 1;
        pathVis[node] = 1;
        for(Integer it : adj.get(node)){
            if(vis[it] == 0){
                if(detectCycle(adj, it, vis, pathVis) == true){
                    return true;
                }
            }
            else if(pathVis[it] == 1){
                return true;
            }
        }
        pathVis[node] = 0;
        return false;
    }
    
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }

    
    
//    
//     for(int i=0; i<V; i++){
//            if(vis[i] == 0){
//                if(detectCycle(adj, i, vis, pathvis) == true){
//                    return true;
//                }
//            }
//            // pathvis[i] = 0;
//        }
//        
//        return false;
    
    
//    static boolean detectCycle(ArrayList<ArrayList<Integer>> adj, int node, int[] vis, int[] pathvis){
//        
//        vis[node] = 1;
//        pathvis[node] =  1;
//        for(Integer it:adj.get(node)){
//            if(vis[it] == 0){
//                if(detectCycle(adj, it, vis, pathvis) == true){
//                    return true;
//                }
//                else if(pathvis[it] == 1){
//                    return true;
//                }
//            }
//        }
//        
//        pathvis[node] = 0;
//        return false;
//    }
}
