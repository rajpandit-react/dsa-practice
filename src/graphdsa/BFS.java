/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphdsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author PANDIT
 */
public class BFS {
 
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[10];
        int n = 9;
        int m = 9;
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        
        BFS.addEdge(adj, 1, 2);
        BFS.addEdge(adj, 1, 6);
        BFS.addEdge(adj, 2, 1);
        BFS.addEdge(adj, 2, 3);
        BFS.addEdge(adj, 2, 4);
        BFS.addEdge(adj, 3, 2);
        BFS.addEdge(adj, 4, 2);
        BFS.addEdge(adj, 4, 5);
        BFS.addEdge(adj, 5, 4);
        BFS.addEdge(adj, 5, 8);
        BFS.addEdge(adj, 6, 1);
        BFS.addEdge(adj, 6, 7);
        BFS.addEdge(adj, 6, 9);
        BFS.addEdge(adj, 7, 6);
        BFS.addEdge(adj, 7, 8);
        BFS.addEdge(adj, 8, 7);
        BFS.addEdge(adj, 8, 5);
        BFS.addEdge(adj, 9, 6);
        System.out.println("==>"+adj);
        
        ArrayList<Integer> bfs = new ArrayList<>();
       q.add(1);
       vis[1] = true;
       while(!q.isEmpty()){
           Integer node = q.poll();
           bfs.add(node);
           for(Integer it : adj.get(node)){
               if(!vis[it]){
                   vis[it] = true;
                   q.add(it);
               }
           }
       }
        
        System.out.println("bfs => "+bfs);
        vis = new boolean[n+1];
        bfs = new ArrayList<>();
        dfs(1, vis, adj, bfs);
        System.out.println("dfs => "+bfs);
    }
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v)
    {
        adj.get(u).add(v);
    }
    
    public static void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls){
        vis[node] = true;
        ls.add(node);
        adj.get(node).stream().filter((it) -> (!vis[it])).forEachOrdered((it) -> {
            dfs(it, vis, adj, ls);
        });
    }
}
