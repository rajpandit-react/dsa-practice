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
public class Provinces {
 
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=8; i++){
            adj.add(new ArrayList<>());
        }
        boolean vis[] = new boolean[9];
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 4, 5);
        addEdge(adj, 5, 6);
        addEdge(adj, 7, 8);
        System.out.println("adj=="+adj);
        int resCnt = 0;
        for(int i=1; i<9; i++){
            if(!vis[i]){
                resCnt++;
                dfs(adj, i, vis);
            }
        }
        System.out.println("resCnt=="+resCnt);
    }
    
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    
    public static void dfs(ArrayList<ArrayList<Integer>> adj, int node, boolean vis[]){
        vis[node] = true;
        adj.get(node).stream().filter(it -> (!vis[it])).forEachOrdered(it ->{
            dfs(adj,it,vis);
        });
    }
}
